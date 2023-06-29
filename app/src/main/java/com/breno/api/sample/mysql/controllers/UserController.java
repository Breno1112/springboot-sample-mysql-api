package com.breno.api.sample.mysql.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.breno.api.sample.mysql.domain.dtos.request.CreateUserRequestDTO;
import com.breno.api.sample.mysql.domain.dtos.response.CreateUserResponseDTO;
import com.breno.api.sample.mysql.domain.dtos.response.UserDTO;
import com.breno.api.sample.mysql.services.UserService;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public Mono<List<UserDTO>> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping
    public Mono<CreateUserResponseDTO> createUser(@RequestBody CreateUserRequestDTO body) {
        return this.userService.createUser(body);
    }
}
