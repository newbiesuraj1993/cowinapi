package com.cowin.integration.cowinapi.analytics.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.StatusAdapter;


@Component
public class TwitterKafkaStatus extends StatusAdapter {

    private static final Logger  LOG = LoggerFactory.getLogger(TwitterKafkaStatus.class);

    @Override
    public void onStatus(Status status){
        LOG.info(status.getText());
    }


}
