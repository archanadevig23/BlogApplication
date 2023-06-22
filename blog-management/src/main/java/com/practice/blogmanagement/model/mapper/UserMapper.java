package com.practice.blogmanagement.model.mapper;

import com.practice.blogmanagement.model.dto.UserDto;
import com.practice.blogmanagement.model.entity.User;
import com.practice.blogmanagement.model.request.CreateUserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    User map(CreateUserRequest request);

    UserDto map(User user);

}
