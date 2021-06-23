package com.cowin.integration.cowinapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Districts implements Serializable {
    private static final long SerialVersionUID=103;
    @JsonProperty("district_id")
    private Integer districtId;
    @JsonProperty("district_name")
    private String districtName;
}
