package com.practice.blogmanagement.repository;

import com.practice.blogmanagement.model.dto.UserDto;
import com.practice.blogmanagement.model.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findByEmailAndActive(String email, boolean active);

    Mono<Boolean> existsByEmailAndActive(String email, boolean active);

    Mono<User> findByDisplayName(String name);

}
