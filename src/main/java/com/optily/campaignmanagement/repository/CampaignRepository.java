package com.optily.campaignmanagement.repository;

import com.optily.campaignmanagement.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign,Long> {
}
