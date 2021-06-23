package com.cowin.integration.cowinapi.core.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DistrictApIResponse implements Serializable {
    private static final long SerialVersionUID=102;
    private List<Districts> districts;
    private Long ttl;
}
