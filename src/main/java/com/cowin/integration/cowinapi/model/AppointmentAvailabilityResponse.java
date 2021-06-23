package com.cowin.integration.cowinapi.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AppointmentAvailabilityResponse implements Serializable {
    private static final long SerialVersionUID=201;
    private List<Appointments> sessions;

}
