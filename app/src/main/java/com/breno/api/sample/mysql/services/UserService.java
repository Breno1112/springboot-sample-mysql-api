package com.breno.api.sample.mysql.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.breno.api.sample.mysql.domain.dtos.request.CreateUserRequestDTO;
import com.breno.api.sample.mysql.domain.dtos.response.CreateUserResponseDTO;
import com.breno.api.sample.mysql.domain.dtos.response.UserDTO;
import com.breno.api.sample.mysql.domain.repositories.UserRepository;
import com.breno.api.sample.mysql.mappers.UserMapper;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    

    public Mono<List<UserDTO>> getUsers() {
        return this.userRepository.findAll().map(user -> userMapper.fromUserEntityToUserDTO(user)).collectList();
    }

    public Mono<CreateUserResponseDTO> createUser(CreateUserRequestDTO body) {
        return this.userRepository.save(this.userMapper.fromCreateUserRequestDTOToUserEntity(body))
        .flatMap(response -> {
            CreateUserResponseDTO toReturn = new CreateUserResponseDTO();
            toReturn.setSuccess(true);
            toReturn.setError(null);
            return Mono.just(toReturn);
        })
        .doOnError(error -> {
            CreateUserResponseDTO toReturn = new CreateUserResponseDTO();
            toReturn.setSuccess(false);
            toReturn.setError("Um erro ocorreu ao tentar criar o usuário");
        });
    }
}
