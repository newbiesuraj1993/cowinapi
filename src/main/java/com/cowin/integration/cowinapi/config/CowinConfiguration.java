package com.cowin.integration.cowinapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix ="cowin")
public class CowinConfiguration {

    private String productionUrl;
    private String statesList;
    private String districtList;
    private String appointmentlistbypincode;
    private String appointmentlistbydistrict;
    private String generateotp;
    private String confirmotp;
    private String certificatedownload;
}
