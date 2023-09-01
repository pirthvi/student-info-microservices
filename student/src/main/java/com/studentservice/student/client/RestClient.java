package com.studentservice.student.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public interface RestClient {

    public <V> V sendRequest(final String url, final HttpMethod method,
                             final HttpEntity<?> laminexRequestEntity, final Class responseClass)
            throws  HttpClientErrorException;
}
