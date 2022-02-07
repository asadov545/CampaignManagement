package com.optily.campaignmanagement.controller;

import com.optily.campaignmanagement.dto.OptimisationDto;
import com.optily.campaignmanagement.dto.RecommendationDto;
import com.optily.campaignmanagement.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RecommendationsController {

    private final RecommendationService recommendationService;

    @RequestMapping(value = "/accept", method = RequestMethod.POST)
    public ResponseEntity<List<RecommendationDto>> getAcceptLatesRecomendations(@RequestParam("campaigngroupid") long campaignGroupId){
        return ResponseEntity.ok(recommendationService.accept(campaignGroupId));

    }

    @RequestMapping(value = "/recommendationsByOptimisationId", method = RequestMethod.GET)
    public ResponseEntity<List<RecommendationDto>> getRecommendationsByOptimisationId(@RequestParam("optimisationId") long optimisationId){
        return ResponseEntity.ok(recommendationService.getRecommendationsByOptimisationId(optimisationId));

    }

}
