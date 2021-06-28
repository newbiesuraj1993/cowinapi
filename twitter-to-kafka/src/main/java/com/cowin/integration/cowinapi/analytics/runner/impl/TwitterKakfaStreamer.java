package com.cowin.integration.cowinapi.analytics.runner.impl;

import com.cowin.integration.commons.TwitterToKafkaConfig;
import com.cowin.integration.cowinapi.analytics.listener.TwitterKafkaStatus;
import com.cowin.integration.cowinapi.analytics.runner.StreamRunner;
import org.springframework.stereotype.Component;
import twitter4j.*;

import javax.annotation.PreDestroy;

@Component
public class TwitterKakfaStreamer implements StreamRunner {


    private final TwitterToKafkaConfig twitterToKafkaConfig;

    private final TwitterKafkaStatus twitterKafkaStatus;

    private TwitterStream twitterStream;

    public TwitterKakfaStreamer(TwitterToKafkaConfig twitterToKafkaConfig, TwitterKafkaStatus twitterKafkaStatus) {
        this.twitterToKafkaConfig = twitterToKafkaConfig;
        this.twitterKafkaStatus = twitterKafkaStatus;
    }

    @PreDestroy
    public void shutDown(){
        if(twitterStream != null) {
            twitterStream.shutdown();
        }
    }


    @Override
    public void start() throws TwitterException {
        twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(twitterKafkaStatus);
        addFilter();

    }

    private void addFilter() {
        String[] keywords = twitterToKafkaConfig.getTwitterKeywords().toArray(new String[0]);
        FilterQuery filterQuery = new FilterQuery(keywords);
        twitterStream.filter(filterQuery);
    }
}
