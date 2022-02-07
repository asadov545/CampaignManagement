package com.optily.campaignmanagement.service.impl;

import com.optily.campaignmanagement.dto.CampaignDto;
import com.optily.campaignmanagement.dto.OptimisationDto;
import com.optily.campaignmanagement.dto.RecommendationDto;
import com.optily.campaignmanagement.entity.Campaign;
import com.optily.campaignmanagement.entity.CampaignGroup;
import com.optily.campaignmanagement.entity.Optimisation;
import com.optily.campaignmanagement.entity.Recommendation;
import com.optily.campaignmanagement.repository.RecommendationRepository;
import com.optily.campaignmanagement.service.CampaignService;
import com.optily.campaignmanagement.service.OptimisationService;
import com.optily.campaignmanagement.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecommendationServiceImpl implements RecommendationService {

    private final CampaignService campaignService;
    private final OptimisationService optimisationService;
    private final ModelMapper modelMapper;
    private final RecommendationRepository recommendationRepository;

    @Transactional
    @Override
    public List<RecommendationDto> accept(long campGroupId) {

        //get campain list
        List<CampaignDto> campaignDtoList = campaignService.getCampainsByCampaignGroupId(campGroupId);

        //calculate sum imppression and budget
        double sumImpression =campaignDtoList.stream().mapToDouble(i -> i.getImpressions()).sum();
        double sumBudget = campaignDtoList.stream().mapToDouble(i -> i.getBudget()).sum();

        //update Old optimisation status
        optimisationService.updateOldOptimisations(campGroupId);

        // save optimisation
        CampaignGroup campaignGroup=new CampaignGroup();
        campaignGroup.setId(campGroupId);
        OptimisationDto optimisationDto=new OptimisationDto();
        optimisationDto.setCampaignGroup(campaignGroup);
        optimisationDto.setOptimisationStatus((short) 1);
        optimisationService.save(optimisationDto);
        /////------------------------------------------

        //Recommendation
        List<Recommendation> recommendation=new ArrayList<>();
        Campaign campaign=new Campaign();


        for (int i = 0; i < campaignDtoList.size(); i++) {
            campaign.setId(campaignDtoList.get(i).getId());
            double recommendedBudget=campaignDtoList.get(i).getImpressions()/sumImpression*sumBudget;
            RecommendationDto rec=new RecommendationDto();

            rec.setRecommentedBudget(recommendedBudget);
            rec.setCampaign(campaign);
            rec.setOptimisation(modelMapper.map(optimisationDto,Optimisation.class));
            save(rec);

        }


        return getRecommendationsByOptimisationId(optimisationDto.getId());
    }

    @Override
    public RecommendationDto save(RecommendationDto recommendationDto) {
        Recommendation recommendation=modelMapper.map(recommendationDto,Recommendation.class);
        recommendation=recommendationRepository.save(recommendation);
        recommendationDto.setId(recommendation.getId());
        return recommendationDto;
    }

    @Override
    public List<RecommendationDto> getRecommendationsByOptimisationId(long optimisationId) {
        List<RecommendationDto> all = recommendationRepository.findByOptimisationId(optimisationId)
                .stream()
                .map(recommendation -> modelMapper.map(recommendation, RecommendationDto.class))
                .collect(Collectors.toList());
        return all ;
    }


}
