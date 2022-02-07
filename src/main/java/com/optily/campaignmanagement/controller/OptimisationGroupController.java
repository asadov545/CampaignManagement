package com.optily.campaignmanagement.controller;

import com.optily.campaignmanagement.dto.CampaignDto;
import com.optily.campaignmanagement.dto.OptimisationDto;
import com.optily.campaignmanagement.service.OptimisationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/optimisationgroup")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OptimisationGroupController {

    private final  OptimisationService optimisationService;

    @RequestMapping(value = "/optsbycampaigngroupid", method = RequestMethod.GET)
    public ResponseEntity<List<OptimisationDto>> getRecommendationsByOptimisationId(@RequestParam("campaigngroupid") long campaigngroupid){
        return ResponseEntity.ok(optimisationService.getOptimisationsByCampaignGroupId(campaigngroupid));

    }



}
