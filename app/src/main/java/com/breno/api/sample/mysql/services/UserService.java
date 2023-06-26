package com.breno.api.sample.mysql.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
