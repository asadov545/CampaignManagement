package com.optily.campaignmanagement.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "optimisation_id")
    private Optimisation optimisation;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    private  double recommentedBudget;
}
