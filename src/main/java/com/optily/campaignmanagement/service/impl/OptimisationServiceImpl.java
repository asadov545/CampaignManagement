package com.optily.campaignmanagement.service.impl;

import com.optily.campaignmanagement.dto.CampaignDto;
import com.optily.campaignmanagement.dto.OptimisationDto;
import com.optily.campaignmanagement.entity.CampaignGroup;
import com.optily.campaignmanagement.entity.Optimisation;
import com.optily.campaignmanagement.repository.OptimisationRepository;
import com.optily.campaignmanagement.service.OptimisationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OptimisationServiceImpl implements OptimisationService {


    private final ModelMapper modelMapper;
    private final OptimisationRepository optimisationRepository;
    @Override
    public List<OptimisationDto> getOptimisationsByCampaignGroupId(long cam_group_id) {
        List<OptimisationDto> all = optimisationRepository.findByCampaignGroupId(cam_group_id)
                .stream()
                .map(optimisation -> modelMapper.map(optimisation,  OptimisationDto.class))
                .collect(Collectors.toList());
        return all ;
    }

    @Override
    public OptimisationDto save(OptimisationDto optimisationDto) {
        Optimisation optimisation=modelMapper.map(optimisationDto,Optimisation.class);
        optimisation=optimisationRepository.save(optimisation);
        optimisationDto.setId(optimisation.getId());
        return optimisationDto;
    }

    @Override
    public void updateOldOptimisations(long cam_group_id) {
        optimisationRepository.updateOldOptimisation(cam_group_id);
    }
}
