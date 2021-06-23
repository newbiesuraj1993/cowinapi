package com.cowin.integration.cowinapi.services.implementations;

import com.cowin.integration.cowinapi.config.CowinConfiguration;
import com.cowin.integration.cowinapi.model.AppointmentAvailabilityResponse;
import com.cowin.integration.cowinapi.model.Districts;
import com.cowin.integration.cowinapi.model.States;
import com.cowin.integration.cowinapi.services.CoWinAppointmentService;
import com.cowin.integration.cowinapi.services.CoWinLocationService;
import com.cowin.integration.cowinapi.utils.RestCallUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CoWinAppointmentServiceImpl implements CoWinAppointmentService {

    @Autowired
    private RestCallUtil restCallUtil;

    @Autowired
    private CowinConfiguration cowinConfiguration;

    @Autowired
    private CoWinLocationService coWinLocationService;

    private static final HttpHeaders headers;

    static {
        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.ALL));
        headers.add("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36 Edg/90.0.818.51");
    }


    @Override
    public AppointmentAvailabilityResponse findAppointmentByPincode(Integer pincode, String date) {

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("pincode", pincode.toString());
        queryParams.put("date", date);

        try {
            return restCallUtil.restGetCall(cowinConfiguration.getProductionUrl() + cowinConfiguration.getAppointmentlistbypincode(), headers, queryParams, AppointmentAvailabilityResponse.class);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    @Override
    @Cacheable(value = "districtrelcache",key = "#districtId")
    public AppointmentAvailabilityResponse findAppointmentByDistrict(Integer districtId, String date) {
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("district_id", districtId.toString());
        queryParams.put("date", date);

        try {
            return restCallUtil.restGetCall(cowinConfiguration.getProductionUrl() + cowinConfiguration.getAppointmentlistbydistrict(), headers, queryParams, AppointmentAvailabilityResponse.class);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    @Cacheable(value = "districtstaterelcache",key = "#districtName")
    public AppointmentAvailabilityResponse findAppointmentByDistrict(String stateName, String districtName, String date) {

        List<States> statesList = coWinLocationService.getAllStates().getStates();
        String stateId = "";
        for(States state : statesList) {
            if(state.getStateName().equalsIgnoreCase(stateName)) {
                stateId = state.getStateId().toString();
            }
        }

        List<Districts> districts = coWinLocationService.findDistrictsByStateId(stateId).getDistricts();
        String districtId = "";
        for(Districts district : districts) {
            if(district.getDistrictName().equalsIgnoreCase(districtName)) {
                districtId = district.getDistrictId().toString();
            }
        }

        return findAppointmentByDistrict(Integer.parseInt(districtId), date);
    }

}
