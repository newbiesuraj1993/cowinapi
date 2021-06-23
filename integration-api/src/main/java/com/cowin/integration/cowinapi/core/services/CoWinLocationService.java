package com.cowin.integration.cowinapi.core.services;


import com.cowin.integration.cowinapi.core.model.DistrictApIResponse;
import com.cowin.integration.cowinapi.core.model.StatesApIResponse;

public interface CoWinLocationService {

    StatesApIResponse getAllStates();
    DistrictApIResponse findDistrictsByStateId(String stateId);
}
