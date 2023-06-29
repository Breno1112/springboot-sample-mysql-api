package com.breno.api.sample.mysql.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.breno.api.sample.mysql.domain.dtos.request.CreateUserRequestDTO;
import com.breno.api.sample.mysql.domain.dtos.response.UserDTO;
import com.breno.api.sample.mysql.domain.entities.UserEntity;

@Component
public class UserMapper {
    
    public UserDTO fromUserEntityToUserDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setName(userEntity.getName());
        userDTO.setAge(userEntity.getAge());
        return userDTO;
    }

    public List<UserDTO> fromUserEntitiesToUserDTOs(List<UserEntity> userEntities) {
        return userEntities.stream().map(value -> this.fromUserEntityToUserDTO(value)).collect(Collectors.toList());
    }

    public UserEntity fromCreateUserRequestDTOToUserEntity(CreateUserRequestDTO body) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(body.getName());
        userEntity.setAge(body.getAge());
        return userEntity;
    }
}
