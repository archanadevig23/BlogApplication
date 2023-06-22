package com.practice.blogmanagement.service.impl;

import com.practice.blogmanagement.model.dto.UserDto;
import com.practice.blogmanagement.model.entity.User;
import com.practice.blogmanagement.model.error.Errors;
import com.practice.blogmanagement.model.exceptions.AppException;
import com.practice.blogmanagement.model.request.CreateUserRequest;
import com.practice.blogmanagement.repository.UserRepository;
import com.practice.blogmanagement.service.UserService;
import com.practice.blogmanagement.service.utils.PasswordEnc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.practice.blogmanagement.model.mapper.UserMapper.userMapper;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEnc passwordEnc;

    private final static boolean ACTIVE = true;

    @Override
    public Mono<UserDto> createUser(CreateUserRequest request) {
        return userRepository
                .existsByEmailAndActive(request.getEmail(), ACTIVE)
                .filter(exists -> exists)
                .flatMap(b -> Mono.error(new AppException(Errors.USER_EXISTS)))
                .then(
                        Mono.fromSupplier(() -> userMapper.map(request))
                                .map(user -> {
                                    user.setPassword(passwordEnc.encode(user.getPassword()));
                                    return user;
                                })
                                .flatMap(userRepository::insert)
                                .map(userMapper::map)

                );
    }



    @Override
    public Mono<UserDto> getUser(String name) {
        return userRepository
                .findByDisplayName(name)
                .switchIfEmpty(Mono.error(new AppException(Errors.USER_DOESNT_EXISTS)))
                .map(user -> userMapper.map(user));
    }

    @Override
    public Mono<UserDto> loginUser(String email, String password) {
        return null;
    }
}
