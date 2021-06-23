package com.cowin.integration.cowinapi.services;

import com.cowin.integration.cowinapi.model.AppointmentAvailabilityResponse;

public interface CoWinAppointmentService {

    AppointmentAvailabilityResponse findAppointmentByPincode(Integer pincode, String date);
    AppointmentAvailabilityResponse findAppointmentByDistrict(Integer districtId, String date);
    AppointmentAvailabilityResponse findAppointmentByDistrict(String stateName, String districtName, String date);

}
