package com.optily.campaignmanagement.dto;

import com.optily.campaignmanagement.entity.Campaign;
import com.optily.campaignmanagement.entity.Optimisation;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RecommendationDto {

    private long id;
    private Optimisation optimisation;
    private Campaign campaign;
    private  double recommentedBudget;
}
