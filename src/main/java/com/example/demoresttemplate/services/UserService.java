package com.example.demoresttemplate.services;

import com.example.demoresttemplate.models.bo.SystemResponse;
import com.example.demoresttemplate.models.in.UserIn;
import com.example.demoresttemplate.models.out.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<SystemResponse<List<UserDTO>>> getAll();

    ResponseEntity<SystemResponse<UserDTO>> create(UserIn userIn);

    ResponseEntity<SystemResponse<UserDTO>> getUserById(int id);
}
