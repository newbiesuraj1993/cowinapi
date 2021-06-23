package com.cowin.integration.cowinapi.core.controller;

import com.cowin.integration.cowinapi.core.model.AppointmentAvailabilityResponse;
import com.cowin.integration.cowinapi.core.services.CoWinAppointmentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/appointment")
public class CoWinAppointmentController {

    @Autowired
    private CoWinAppointmentService coWinAppointmentService;

    @ApiOperation(value = "This API calls findByPin API of CoWin Appointment services")
    @GetMapping("findByPin")
    public AppointmentAvailabilityResponse findAppointmentByPincode(
            @ApiParam(name = "pincode", type = "String", value = "Pincode", example = "110001",required = true) @RequestParam(name = "pincode") @NonNull Integer pincode,
            @ApiParam(name = "date", type = "String", value = "Date of Appointment(dd-MM-yyyy)", example = "01-05-2021",required = true) @RequestParam(name = "date") @NonNull String date){
        return coWinAppointmentService.findAppointmentByPincode(pincode,date);
    }

    @ApiOperation(value = "This API calls findByDistrict API of CoWin Appointment services")
    @GetMapping("findByDistrict")
    public AppointmentAvailabilityResponse findAppointmentByDistrict(
            @ApiParam(name = "district_id", type = "String", value = "District Id", example = "213",required = true) @RequestParam(name = "district_id") @NonNull Integer disctrictId,
            @ApiParam(name = "date", type = "String", value = "Date of Appointment(dd-MM-yyyy)", example = "01-05-2021",required = true) @RequestParam(name = "date") @NonNull String date){
        return coWinAppointmentService.findAppointmentByDistrict(disctrictId,date);
    }

    @ApiOperation(value = "This API call will return district details based on name of state and district")
    @GetMapping("findByDistrictName")
    public  AppointmentAvailabilityResponse findAppointmentByDistrict(
            @ApiParam(name = "district_name", type = "String", value = "District Name", example = "Mumbai",required = true) @RequestParam(name = "district_name") @NonNull String districtName,
            @ApiParam(name = "state_name", type = "String", value = "State Name", example = "Maharashtra",required = true) @RequestParam(name = "state_name") @NonNull String stateName,
            @ApiParam(name = "date", type = "String", value = "Date of Appointment(dd-MM-yyyy)", example = "01-05-2021",required = true) @RequestParam(name = "date") @NonNull String date){
        return coWinAppointmentService.findAppointmentByDistrict(stateName,districtName,date);
    }

}
