package com.optily.campaignmanagement.controller;

import com.optily.campaignmanagement.dto.CampaignDto;
import com.optily.campaignmanagement.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CampaignsController {

    private final CampaignService campaignService;

    @RequestMapping(value = "/campaignsbycampaigngroupid", method = RequestMethod.GET)
    public ResponseEntity<List<CampaignDto>> getAllCampaignsByCampaignGroupId(@RequestParam("campaigngroupid") long campaigngroupid){
              return ResponseEntity.ok(campaignService.getCampainsByCampaignGroupId(campaigngroupid));

    }

}
