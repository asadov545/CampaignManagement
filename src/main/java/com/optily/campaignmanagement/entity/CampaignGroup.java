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
public class CampaignGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;


    @OneToMany
    @JoinColumn(name = "campaigngroup_campaign_id")
    private List<Campaign> campaignList;

    @OneToMany
    @JoinColumn(name = "campaigngroup_optimisation_id")
    private List<Optimisation> optimisationList;
}
