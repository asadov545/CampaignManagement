package com.optily.campaignmanagement.controller;

import com.optily.campaignmanagement.dto.CampaignGroupDto;
import com.optily.campaignmanagement.service.CampaignGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaigngroup")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CampaignGroupController {


    private final CampaignGroupService campaignGroupService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<CampaignGroupDto>> getAllCampaignGroup() {
        return ResponseEntity.ok(campaignGroupService.findAll());
    }


}
