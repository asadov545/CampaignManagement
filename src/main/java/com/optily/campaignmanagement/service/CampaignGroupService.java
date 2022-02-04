package com.optily.campaignmanagement.service;

import com.optily.campaignmanagement.dto.CampaignGroupDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CampaignGroupService {
    CampaignGroupDto save(CampaignGroupDto campaignGroupDto);
    List<CampaignGroupDto> getAll();

}
