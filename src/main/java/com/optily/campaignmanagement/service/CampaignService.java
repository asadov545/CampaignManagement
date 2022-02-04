package com.optily.campaignmanagement.service;

import com.optily.campaignmanagement.dto.CampaignDto;
import org.springframework.stereotype.Service;

@Service
public interface CampaignService {

    CampaignDto getByCampaignGroupId(long id);

}
