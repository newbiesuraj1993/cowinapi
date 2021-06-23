package com.cowin.integration.cowinapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Appointments implements Serializable {
        private static final long SerialVersionUID=202;

        @JsonProperty("center_id")
        private Integer centerId;
        @JsonProperty("name")
        private String name;
        @JsonProperty("address")
        private String address;
        @JsonProperty("state_name")
        private String stateName;
        @JsonProperty("district_name")
        private String districtName;
        @JsonProperty("block_name")
        private String blockName;
        @JsonProperty("pincode")
        private Integer pincode;
        @JsonProperty("from")
        private String from;
        @JsonProperty("to")
        private String to;
        @JsonProperty("lat")
        private Double lat;
        @JsonProperty("long")
        private Double lng;
        @JsonProperty("fee_type")
        private String feeType;
        @JsonProperty("session_id")
        private String session_id;
        @JsonProperty("date")
        private String date;
        @JsonProperty("available_capacity")
        private String available_capacity;
        @JsonProperty("available_capacity_dose1")
        private String available_capacity_dose1;
        @JsonProperty("available_capacity_dose2")
        private String available_capacity_dose2;
        @JsonProperty("fee")
        private String fee;
        @JsonProperty("min_age_limit")
        private Integer minAgeLimit;
        @JsonProperty("vaccine")
        private String vaccine;
        @JsonProperty("slots")
        private List<String> slots;


}

