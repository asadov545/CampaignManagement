package com.optily.campaignmanagement.configuration;

import com.optily.campaignmanagement.dto.CampaignGroupDto;
import com.optily.campaignmanagement.service.CampaignGroupService;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor


public class LoadDefault {




    public void defaultDataSave() {
        CampaignGroupDto campaignGroupDto = new CampaignGroupDto();
        campaignGroupDto.setName("Group1");
        // campaignGroupDto.setName("Group2");
        // campaignGroupDto.setName("Group3");
     //   campaignGroupService.save(campaignGroupDto);
    }
}
