package com.cowin.integration.cowinapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class OTPResponse {
    @ApiModelProperty(notes = "Session token")
    private String token;
}