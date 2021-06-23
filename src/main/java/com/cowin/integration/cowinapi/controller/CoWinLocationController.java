package com.cowin.integration.cowinapi.controller;

import com.cowin.integration.cowinapi.model.DistrictApIResponse;
import com.cowin.integration.cowinapi.model.StatesApIResponse;
import com.cowin.integration.cowinapi.services.CoWinLocationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/location")
@Api(value ="This controller helps to fetch the district and state list enrolled in GOI API")
public class CoWinLocationController {

    @Autowired
    private CoWinLocationService coWinLocationService;

    @ApiOperation(value = "This API fetches all States from CoWin public APIs")
    @GetMapping("states")

    public StatesApIResponse getCowinStateListForAPI(){
        return coWinLocationService.getAllStates();
    }

    @ApiOperation(value = "This API fetches all districts for a state from CoWin public APIs")
    @GetMapping("states/districts")
    public DistrictApIResponse findDistrictsByStateId(@ApiParam(name = "state_id", type = "String", value = "State Id", example = "1",required = true)
                                                        @RequestParam(name = "state_id") String stateId){
        return coWinLocationService.findDistrictsByStateId(stateId);
    }


}
