package com.optily.campaignmanagement.dto;

import com.optily.campaignmanagement.entity.CampaignGroup;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CampaignDto {
    private long id;
    private CampaignGroup campaignGroup;
    private String name;
    private double budget;
    private double impressions;
    private double revenue;
}
