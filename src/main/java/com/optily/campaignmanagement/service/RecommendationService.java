package com.optily.campaignmanagement.service;

import com.optily.campaignmanagement.dto.CampaignGroupDto;
import com.optily.campaignmanagement.dto.OptimisationDto;
import com.optily.campaignmanagement.dto.RecommendationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecommendationService {
    List<RecommendationDto> accept(long campGroupId);
    RecommendationDto save(RecommendationDto recommendationDto);
    List<RecommendationDto> getRecommendationsByOptimisationId(long optimisationId);
}
