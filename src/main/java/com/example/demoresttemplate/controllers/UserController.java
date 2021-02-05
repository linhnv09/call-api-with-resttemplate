package com.example.demoresttemplate.controllers;

import com.example.demoresttemplate.models.bo.SystemResponse;
import com.example.demoresttemplate.models.in.UserIn;
import com.example.demoresttemplate.models.out.UserDTO;
import com.example.demoresttemplate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest-template/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<SystemResponse<List<UserDTO>>> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public ResponseEntity<SystemResponse<UserDTO>> create(@RequestBody UserIn userIn) {
        return userService.create(userIn);
    }
//
    @GetMapping("/{id}")
    public ResponseEntity<SystemResponse<UserDTO>> getUser(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }
}
