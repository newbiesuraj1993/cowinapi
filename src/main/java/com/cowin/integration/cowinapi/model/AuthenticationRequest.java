package com.cowin.integration.cowinapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    @ApiModelProperty(notes = "Mobile number of the user")
    private String mobile;
}
