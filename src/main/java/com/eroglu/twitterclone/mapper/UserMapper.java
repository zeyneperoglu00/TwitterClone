package com.eroglu.twitterclone.mapper;

import com.eroglu.twitterclone.dto.UserResponse;
import com.eroglu.twitterclone.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", source = "userId")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "followers", source = "follower_count")
    @Mapping(target = "following", source = "following_count")
    @Mapping(target = "bio", source = "bio")
    UserResponse mapToDto(User user);
}
