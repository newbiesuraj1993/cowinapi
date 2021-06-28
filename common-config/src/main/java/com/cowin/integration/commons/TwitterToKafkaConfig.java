package com.cowin.integration.commons;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Data
@ConfigurationProperties(prefix="twitter-to-kafka")
public class TwitterToKafkaConfig {

    private List<String> twitterKeywords;
}
