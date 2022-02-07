package com.optily.campaignmanagement.repository;


import com.optily.campaignmanagement.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign,Long> {
    @Query(value = "SELECT * FROM campaign c  where c.campaigngroup_id = ?1", nativeQuery = true)
    List<Campaign> findByCampaignGroupId(long cam_group_id);
}
