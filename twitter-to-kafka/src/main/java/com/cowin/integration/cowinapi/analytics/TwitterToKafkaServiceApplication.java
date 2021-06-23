package com.cowin.integration.cowinapi.analytics;

import com.cowin.integration.cowinapi.analytics.config.TwitterToKafkaConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class TwitterToKafkaServiceApplication implements CommandLineRunner {


    private static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);

    @Autowired
    private TwitterToKafkaConfig twitterToKafkaConfig;

    public static void main(String[] args) {
        SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Hello");
        LOG.info(Arrays.toString(twitterToKafkaConfig.getTwitterKeywords().toArray(new String[] {})));
    }
}
