package com.cowin.integration.cowinapi.services;


import com.cowin.integration.cowinapi.model.DistrictApIResponse;
import com.cowin.integration.cowinapi.model.StatesApIResponse;

public interface CoWinLocationService {

    StatesApIResponse getAllStates();
    DistrictApIResponse findDistrictsByStateId(String stateId);
}
