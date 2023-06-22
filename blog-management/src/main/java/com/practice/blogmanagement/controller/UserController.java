package com.practice.blogmanagement.controller;

import com.practice.blogmanagement.model.dto.UserDto;
import com.practice.blogmanagement.model.request.CreateUserRequest;
import com.practice.blogmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public Mono<UserDto> createUser(@RequestBody CreateUserRequest request) {
        System.out.println("In service controller");
        return userService.createUser(request);
//                .map(ResponseEntity::ok);
    }

    @GetMapping("/{name}")
    public Mono<ResponseEntity<UserDto>> getUser(@PathVariable String name) {
        return userService.getUser(name)
                .map(ResponseEntity::ok);
    }

}
