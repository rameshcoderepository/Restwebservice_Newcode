package com.uniqTechnologies.restfulwebservices.user;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestApiCaller {
    private static final String API_URL = "http://localhost:8080/hello";
    private static final String JWT_TOKEN = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJVbmlxVGVjaCIsImV4cCI6MTcwNzM5MzQwNywiaWF0IjoxNzA3Mzc1NDA3fQ.ZeCX4N7-CkNIl7O6UZd5uOes_EM8-53kzPUX_RlSmynLin5-BUqe5pVkZXgeKW4VFEvnhVlWXWBGnEd_CWAVdg";

    public static void main(String[] args) {
        // Create HttpHeaders with JWT token
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(JWT_TOKEN);

        // Create a HttpEntity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Make a GET request with the JWT token
        ResponseEntity<String> response = restTemplate.exchange(API_URL, HttpMethod.GET, entity, String.class);

        // Process the response
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Response Body: " + response.getBody());
        } else {
            System.out.println("Request failed with status code: " + response.getStatusCode());
        }
    }
}

