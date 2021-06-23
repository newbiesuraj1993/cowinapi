package com.cowin.integration.cowinapi.core.services;

import com.cowin.integration.cowinapi.core.model.AuthenticationRequest;
import com.cowin.integration.cowinapi.core.model.AuthenticationResponse;
import com.cowin.integration.cowinapi.core.model.OTPRequest;
import com.cowin.integration.cowinapi.core.model.OTPResponse;

public interface CoWinAuthenticationService {


    AuthenticationResponse generateOtp(AuthenticationRequest request);
    OTPResponse confirmOtp(OTPRequest request);
}
