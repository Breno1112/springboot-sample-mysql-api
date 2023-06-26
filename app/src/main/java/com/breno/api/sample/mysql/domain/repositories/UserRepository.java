package com.breno.api.sample.mysql.domain.repositories;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.breno.api.sample.mysql.domain.entities.UserEntity;

@Repository
public interface UserRepository extends R2dbcRepository<UserEntity, Integer> {
    
}
