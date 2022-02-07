package com.optily.campaignmanagement.repository;

import com.optily.campaignmanagement.entity.Optimisation;
import com.optily.campaignmanagement.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation,Long> {

    @Query(value = "SELECT * FROM recommendation where optimisation_id=?1", nativeQuery = true)
    List<Recommendation> findByOptimisationId(long optimisationId);
}
