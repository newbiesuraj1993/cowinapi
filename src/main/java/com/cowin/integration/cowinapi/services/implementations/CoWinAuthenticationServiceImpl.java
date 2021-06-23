package com.cowin.integration.cowinapi.services.implementations;

import com.cowin.integration.cowinapi.config.CowinConfiguration;
import com.cowin.integration.cowinapi.model.AuthenticationRequest;
import com.cowin.integration.cowinapi.model.AuthenticationResponse;
import com.cowin.integration.cowinapi.model.OTPRequest;
import com.cowin.integration.cowinapi.model.OTPResponse;
import com.cowin.integration.cowinapi.services.CoWinAuthenticationService;
import com.cowin.integration.cowinapi.utils.RestCallUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CoWinAuthenticationServiceImpl implements CoWinAuthenticationService {

    @Autowired
    private RestCallUtil restCallUtil;

    @Autowired
    private CowinConfiguration cowinConfiguration;


    private static final HttpHeaders headers;
    static{
        headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.ALL));
        headers.add("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36 Edg/90.0.818.51");
    }

    @Override
    public AuthenticationResponse generateOtp(AuthenticationRequest request) {
        try{
            return restCallUtil.restPostCall(cowinConfiguration.getProductionUrl()+cowinConfiguration.getGenerateotp(), headers,
                    null, request, AuthenticationResponse.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public OTPResponse confirmOtp(OTPRequest otpRequest) {
        try{
            return restCallUtil.restPostCall(cowinConfiguration.getProductionUrl()+cowinConfiguration.getConfirmotp(), headers,
                    null, otpRequest, OTPResponse.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
