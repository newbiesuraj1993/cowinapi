package com.cowin.integration.cowinapi.core.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class AuthenticationResponse {
    @ApiModelProperty(notes = "transaction id of the request")
    private String txnId;
}