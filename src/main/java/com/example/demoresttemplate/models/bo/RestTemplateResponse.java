package com.example.demoresttemplate.models.bo;

import com.example.demoresttemplate.models.out.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

public class RestTemplateResponse {
    @Autowired
    private static RestTemplate restTemplate;

    public static <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, Class<T> responseType) {
        return restTemplate.exchange(requestEntity, responseType);
    }

    public static <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, ParameterizedTypeReference<T> responseType) {
        return restTemplate.exchange(requestEntity, responseType);
    }

    public static <T> ResponseEntity<T> postForEntity(URI url, Object requestObject, Class<T> responseType) {
        return restTemplate.postForEntity(url, requestObject, responseType);
    }

    public static <T> ResponseEntity<T> getForEntity(URI url, Class<T> responseType) {
        return restTemplate.getForEntity(url, responseType);
    }
}
