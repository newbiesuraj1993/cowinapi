package com.cowin.integration.cowinapi.services;

import com.cowin.integration.cowinapi.model.AuthenticationRequest;
import com.cowin.integration.cowinapi.model.AuthenticationResponse;
import com.cowin.integration.cowinapi.model.OTPRequest;
import com.cowin.integration.cowinapi.model.OTPResponse;

public interface CoWinAuthenticationService {


    AuthenticationResponse generateOtp(AuthenticationRequest request);
    OTPResponse confirmOtp(OTPRequest request);
}
