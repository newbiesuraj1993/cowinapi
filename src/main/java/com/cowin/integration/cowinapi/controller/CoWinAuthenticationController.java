package com.cowin.integration.cowinapi.controller;

import com.cowin.integration.cowinapi.model.AuthenticationRequest;
import com.cowin.integration.cowinapi.model.AuthenticationResponse;
import com.cowin.integration.cowinapi.model.OTPRequest;
import com.cowin.integration.cowinapi.model.OTPResponse;
import com.cowin.integration.cowinapi.services.CoWinAuthenticationService;
import com.cowin.integration.cowinapi.utils.GeneralUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/authentication")
@Api(value = "CoWin Authentication services controller")
public class CoWinAuthenticationController {

    @Autowired
    private GeneralUtils generalUtils;

    @Autowired
    private CoWinAuthenticationService coWinAuthenticationService;

    /**
     * This API call generates OTP for CoWin App Registration
     * @param request : @{@link AuthenticationRequest}
     * @return response: @{@link AuthenticationResponse}
     */
    @ApiOperation(value = "This API call generates OTP for CoWin App Registration")
    @PostMapping(value = "generateOtp", produces = MediaType.APPLICATION_JSON_VALUE)
    public AuthenticationResponse generateOtp(@RequestBody AuthenticationRequest request){
        return coWinAuthenticationService.generateOtp(request);
    }

    /**
     * This API call confirms OTP for CoWin App Registration
     * @param request : @{@link OTPRequest}
     * @return response: @{@link OTPResponse}
     */
    @ApiOperation(value = "This API call confirms OTP for CoWin App Registration")
    @PostMapping(value = "confirmOtp", produces = MediaType.APPLICATION_JSON_VALUE)
    public OTPResponse confirmOtp(@RequestBody OTPRequest request)  {
        request.setOtp(generalUtils.getSHA256(request.getOtp()));
        return coWinAuthenticationService.confirmOtp(request);
    }
}
