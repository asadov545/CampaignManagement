package com.optily.campaignmanagement.service.impl;

import com.optily.campaignmanagement.dto.CampaignGroupDto;
import com.optily.campaignmanagement.entity.CampaignGroup;
import com.optily.campaignmanagement.repository.CampaignGroupRepository;
import com.optily.campaignmanagement.service.CampaignGroupService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


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
    public List<CampaignGroupDto> findAll() {

        List<CampaignGroupDto> all = campaignGroupRepository.findAll()
                .stream()
                .map(campaignGroup -> modelMapper.map(campaignGroup,  CampaignGroupDto.class))
                .collect(Collectors.toList());
        return all ;
    }
}
