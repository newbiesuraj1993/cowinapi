package com.cowin.integration.cowinapi.core.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StatesApIResponse implements Serializable {
    private static final long SerialVersionUID=105;
    private List<States> states;
    private Long ttl;

}