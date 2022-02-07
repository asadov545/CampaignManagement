package com.optily.campaignmanagement.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "campaigngroup_id")
    private CampaignGroup campaignGroup;
    @Column
    private String name;
    @Column
    private double budget;
    @Column
    private double impressions;
    @Column
    private double revenue;




}
