package com.optily.campaignmanagement.service.impl;

import com.optily.campaignmanagement.dto.CampaignGroupDto;
import com.optily.campaignmanagement.entity.CampaignGroup;
import com.optily.campaignmanagement.repository.CampaignGroupRepository;
import com.optily.campaignmanagement.service.CampaignGroupService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CampaignGroupServiceImpl implements CampaignGroupService {


    private final CampaignGroupRepository campaignGroupRepository;
    private final ModelMapper modelMapper;

    @Override
    public CampaignGroupDto save(CampaignGroupDto campaignGroupDto) {
        CampaignGroup campaignGroup=modelMapper.map(campaignGroupDto,CampaignGroup.class);
        campaignGroup=campaignGroupRepository.save(campaignGroup);
        campaignGroupDto.setId(campaignGroup.getId());
        return campaignGroupDto;
    }

    @Override
    public List<CampaignGroupDto> getAll() {
        return null;
    }
}
