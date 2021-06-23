package com.cowin.integration.cowinapi.services.implementations;

import com.cowin.integration.cowinapi.config.CowinConfiguration;
import com.cowin.integration.cowinapi.model.DistrictApIResponse;
import com.cowin.integration.cowinapi.model.StatesApIResponse;
import com.cowin.integration.cowinapi.services.CoWinLocationService;
import com.cowin.integration.cowinapi.utils.RestCallUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CoWinLocationServiceImpl implements CoWinLocationService {

    @Autowired
    private RestCallUtil restUtils;

    @Autowired
    CowinConfiguration cowinConfiguration;

    private static final HttpHeaders headers;
    static{
        headers=new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.ALL));
        headers.add("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36 Edg/90.0.818.51");
    }



    private static final ObjectMapper mapper= new ObjectMapper();
    @Override
    @Cacheable(value = "statecache")
    public StatesApIResponse getAllStates()  {
        try {
            return restUtils.restGetCall(cowinConfiguration.getProductionUrl()+cowinConfiguration.getStatesList(), headers, null, StatesApIResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Cacheable(value = "districtscache",key = "#stateId")
    public DistrictApIResponse findDistrictsByStateId(String stateId) {
        try{
            return restUtils.restGetCall(cowinConfiguration.getProductionUrl()+cowinConfiguration.getDistrictList()+"/"+stateId, headers, null, DistrictApIResponse.class);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
