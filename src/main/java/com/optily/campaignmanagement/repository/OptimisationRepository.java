package com.optily.campaignmanagement.repository;

import com.optily.campaignmanagement.entity.Campaign;
import com.optily.campaignmanagement.entity.Optimisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OptimisationRepository extends JpaRepository<Optimisation,Long> {


    @Query(value = "SELECT * FROM optimisation o  where o.optimisation_status=1 and o.campaigngroup_id=?1", nativeQuery = true)
    List<Optimisation> findByCampaignGroupId(long cam_group_id);

    @Modifying
    @Query(value = "UPDATE optimisation o set o.optimisation_status=0 WHERE o.campaigngroup_id=?1", nativeQuery = true)
    void updateOldOptimisation(long cam_group_id);


}
