package com.studentservice.student.client.impl;

import com.studentservice.student.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClientImpl implements RestClient {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public <V> V sendRequest(final String url, final HttpMethod method,
                             final HttpEntity<?> requestEntity, final Class responseClass)
            throws HttpClientErrorException {
        ResponseEntity<V> result = null;
        result = restTemplate.exchange(url, method, requestEntity, responseClass);
        return result.getBody();
    }
}

