package com.example.demoresttemplate.controllers;


import com.example.demoresttemplate.models.in.UserIn;
import com.example.demoresttemplate.models.out.UserDTO;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/rest-template/users")
public class UserController {
    private RestTemplate restTemplate = new RestTemplate();
    private String baseURL = "http://localhost:9999/users/";

    @GetMapping
    public List getAll() {
        ResponseEntity<List> responseEntity = restTemplate.exchange(baseURL, HttpMethod.GET, null, List.class);
        return responseEntity.getBody();
    }

    @PostMapping
    public UserDTO create(@RequestBody UserIn userIn) {
        ResponseEntity<UserDTO> responseEntity = restTemplate.postForEntity(baseURL, userIn, UserDTO.class);
        return responseEntity.getBody();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);// Xác định kiểu dữ liệu mong muôn được trả v
        HttpEntity<UserDTO> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<UserDTO> responseEntity = restTemplate.exchange(baseURL + id,
                HttpMethod.GET,
                requestEntity,
                UserDTO.class);
//        ResponseEntity<UserDTO> responseEntity = restTemplate.getForEntity(baseURL + id, UserDTO.class);
        System.out.println("Status Code: " + responseEntity.getStatusCode());
        System.out.println("Response Header: " + responseEntity.getHeaders());
        return responseEntity.getBody();
    }
}
