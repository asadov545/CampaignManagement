package com.optily.campaignmanagement.service;

import com.optily.campaignmanagement.dto.CampaignDto;
import com.optily.campaignmanagement.dto.OptimisationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OptimisationService {
    List<OptimisationDto> getOptimisationsByCampaignGroupId(long cam_group_id);
    OptimisationDto save(OptimisationDto optimisationDto);
    void updateOldOptimisations(long cam_group_id);
}
