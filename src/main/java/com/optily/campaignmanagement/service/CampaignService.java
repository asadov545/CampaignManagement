package com.optily.campaignmanagement.service;

import com.optily.campaignmanagement.dto.CampaignDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CampaignService {

    List<CampaignDto> getCampainsByCampaignGroupId(long campaignGroupId);

}
