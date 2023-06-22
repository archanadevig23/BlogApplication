package com.practice.blogmanagement.service;

import com.practice.blogmanagement.model.dto.UserDto;
import com.practice.blogmanagement.model.entity.User;
import com.practice.blogmanagement.model.request.CreateUserRequest;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserDto> createUser(CreateUserRequest request);

    Mono<UserDto> getUser(String name);

    Mono<UserDto> loginUser(String email, String password);

}
