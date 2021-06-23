package com.cowin.integration.cowinapi.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class RestCallUtil {

    @Autowired
    private RestTemplate restTemplate;

    private final ObjectMapper mapper=new ObjectMapper();

    public <T> T restGetCall(final String url, final HttpHeaders httpHeaders,
                             final Map<String, String> queryParams, Class<T> className) throws IOException{
        ResponseEntity<String> responseEntity=restGetCall(url, httpHeaders, queryParams);
        if(responseEntity.getStatusCode().equals(HttpStatus.OK)){
            return mapper.readValue(responseEntity.getBody(), className);
        }
        else {
            return null;
        }
    }

    private ResponseEntity<String> restGetCall(final String url, final HttpHeaders httpHeaders,
                                               final Map<String, String> queryParams) throws IOException{
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        String uri = url;
        if (null != queryParams && !queryParams.isEmpty()) {
            uri = addQueryParameters(queryParams, uri);
        }
        return restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
    }

    private String addQueryParameters(final Map<String, String> queryParams, final String url)
            throws IOException {
        try {
            List<NameValuePair> params = new ArrayList<>();
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            return new URIBuilder(url).addParameters(params).build().toString();
        } catch (URISyntaxException ex) {
            throw new IOException(ex);
        }
    }

    public <T> T restPostCall(final String url, final HttpHeaders httpHeaders,
                              final Map<String, String> queryParams, final Object request, Class<T> className) throws IOException{
        ResponseEntity<String> responseEntity=restPostCall(url, httpHeaders, queryParams, request);
        if(responseEntity.getStatusCode().equals(HttpStatus.OK)){
            return mapper.readValue(responseEntity.getBody(), className);
        }else{
            return null;
        }
    }
    private ResponseEntity<String> restPostCall(final String url, final HttpHeaders httpHeaders,
                                                final Map<String, String> queryParams, final Object request) throws IOException {
        HttpEntity<String> entity = new HttpEntity<>(mapper.writeValueAsString(request),httpHeaders);
        String uri = url;
        if (null != queryParams && !queryParams.isEmpty()) {
            uri = addQueryParameters(queryParams, uri);
        }
        return restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
    }

}
