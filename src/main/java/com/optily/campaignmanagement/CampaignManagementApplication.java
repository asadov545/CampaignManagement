package com.optily.campaignmanagement;

import com.optily.campaignmanagement.dto.CampaignGroupDto;
import com.optily.campaignmanagement.service.CampaignGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CampaignManagementApplication {



   static CampaignGroupService campaignGroupService;

    public static void main(String[] args) {
        SpringApplication.run(CampaignManagementApplication.class, args);

        CampaignGroupDto campaignGroupDto= new CampaignGroupDto();
        campaignGroupDto.setName("Group1");
       // campaignGroupDto.setName("Group2");
       // campaignGroupDto.setName("Group3");
        campaignGroupService.save(campaignGroupDto);


        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("campaigns.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
