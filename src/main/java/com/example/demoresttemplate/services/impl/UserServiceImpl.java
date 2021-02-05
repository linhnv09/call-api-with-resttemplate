package com.example.demoresttemplate.services.impl;

import com.example.demoresttemplate.models.bo.Response;
import com.example.demoresttemplate.models.bo.RestTemplateResponse;
import com.example.demoresttemplate.models.bo.SystemResponse;
import com.example.demoresttemplate.models.in.UserIn;
import com.example.demoresttemplate.models.out.UserDTO;
import com.example.demoresttemplate.services.UserService;
import com.example.demoresttemplate.utils.StringResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Value("${external.api.url}")
    private String baseUrl;

    @Override
    public ResponseEntity<SystemResponse<List<UserDTO>>> getAll() {
        RequestEntity<UserDTO> requestEntity = new RequestEntity<>(HttpMethod.GET, URI.create(baseUrl));
        ResponseEntity<List<UserDTO>> responseEntity = RestTemplateResponse.exchange(requestEntity,
                new ParameterizedTypeReference<List<UserDTO>>() {
                });
        return Response.ok(StringResponse.SUCCESS, responseEntity.getBody());
    }

    @Override
    public ResponseEntity<SystemResponse<UserDTO>> create(UserIn userIn) {
        ResponseEntity<UserDTO> responseEntity = RestTemplateResponse.postForEntity(URI.create(baseUrl), userIn, UserDTO.class);
        return Response.ok(StringResponse.SUCCESS, responseEntity.getBody());
    }

    @Override
    public ResponseEntity<SystemResponse<UserDTO>> getUserById(int id) {
        RequestEntity<UserDTO> requestEntity = new RequestEntity<>(HttpMethod.GET, URI.create(baseUrl + id));
        ResponseEntity<UserDTO> responseEntity = RestTemplateResponse.exchange(requestEntity, UserDTO.class);
        return Response.ok(StringResponse.SUCCESS, responseEntity.getBody());
    }

}
