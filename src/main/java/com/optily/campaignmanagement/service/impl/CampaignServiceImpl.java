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
@RequiredArgsConstructor
@Service
public class CampaignServiceImpl implements CampaignService {



    private final ModelMapper modelMapper;
    private final CampaignRepository campaignRepository;
    public CampaignDto getByCampaignGroupId(long id) {
        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        return modelMapper.map(campaign, CampaignDto.class);
    }
}
