package com.cowin.integration.cowinapi.core.services;

import com.cowin.integration.cowinapi.core.model.AppointmentAvailabilityResponse;

public interface CoWinAppointmentService {

    AppointmentAvailabilityResponse findAppointmentByPincode(Integer pincode, String date);
    AppointmentAvailabilityResponse findAppointmentByDistrict(Integer districtId, String date);
    AppointmentAvailabilityResponse findAppointmentByDistrict(String stateName, String districtName, String date);

}
