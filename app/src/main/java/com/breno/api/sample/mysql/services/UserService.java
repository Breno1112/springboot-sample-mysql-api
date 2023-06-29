package com.breno.api.sample.mysql.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.breno.api.sample.mysql.domain.dtos.request.CreateUserRequestDTO;
import com.breno.api.sample.mysql.domain.dtos.response.CreateUserResponseDTO;
import com.breno.api.sample.mysql.domain.dtos.response.DeleteResponseDTO;
import com.breno.api.sample.mysql.domain.dtos.response.ResponseDataDTO;
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

    public Mono<ResponseDataDTO<UserDTO>> getUser(String id) {
        return Mono.just(Integer.parseInt(id))
            .flatMap(value -> {
                return this.userRepository.findById(value);
            })
            .flatMap(record -> {
                return Mono.just(this.userMapper.fromUserEntityToUserDTO(record));
            })
            .flatMap(response -> {
                ResponseDataDTO<UserDTO> responseDataDTO = new ResponseDataDTO<UserDTO>();
                responseDataDTO.setData(response);
                return Mono.just(responseDataDTO);
            })
            .onErrorResume(error -> {
                ResponseDataDTO<UserDTO> responseDataDTO = new ResponseDataDTO<UserDTO>();
                responseDataDTO.setError("Erro ao encontrar usuário");
                return Mono.just(responseDataDTO);
            })
            .switchIfEmpty(Mono.just(new ResponseDataDTO<UserDTO>()));
    }

    public Mono<ResponseDataDTO<DeleteResponseDTO>> deleteUser(String id) {
        return Mono.just(Integer.parseInt(id))
            .flatMap(value -> {
                return this.userRepository.deleteById(value);
            })
            .flatMap(response -> {
                ResponseDataDTO<DeleteResponseDTO> responseDataDTO = new ResponseDataDTO<DeleteResponseDTO>();
                DeleteResponseDTO deleteResponseDTO = new DeleteResponseDTO();
                deleteResponseDTO.setDeleted(true);
                responseDataDTO.setData(deleteResponseDTO);
                return Mono.just(responseDataDTO);
            })
            .onErrorResume(error -> {
                ResponseDataDTO<DeleteResponseDTO> responseDataDTO = new ResponseDataDTO<DeleteResponseDTO>();
                responseDataDTO.setError("Erro ao remover usuário");
                return Mono.just(responseDataDTO);
            })
            .switchIfEmpty(Mono.just(new ResponseDataDTO<DeleteResponseDTO>(new DeleteResponseDTO(true), null)));
    }
}
