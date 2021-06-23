package com.cowin.integration.cowinapi.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class States implements Serializable {
    private static final long SerialVersionUID=104;
    @JsonProperty("state_id")
    private Integer stateId;
    @JsonProperty("state_name")
    private String stateName;
}
