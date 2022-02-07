package com.optily.campaignmanagement.service.impl;

import com.optily.campaignmanagement.dto.CampaignDto;
import com.optily.campaignmanagement.dto.CampaignGroupDto;
import com.optily.campaignmanagement.entity.Campaign;
import com.optily.campaignmanagement.entity.CampaignGroup;
import com.optily.campaignmanagement.repository.CampaignRepository;
import com.optily.campaignmanagement.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CampaignServiceImpl implements CampaignService {



    private final ModelMapper modelMapper;
    private final CampaignRepository campaignRepository;


    @Override
    public List<CampaignDto> getCampainsByCampaignGroupId(long cam_group_id) {
        List<CampaignDto> all = campaignRepository.findByCampaignGroupId(cam_group_id)
                .stream()
                .map(campaign -> modelMapper.map(campaign,  CampaignDto.class))
                .collect(Collectors.toList());
        return all ;
    }
}
