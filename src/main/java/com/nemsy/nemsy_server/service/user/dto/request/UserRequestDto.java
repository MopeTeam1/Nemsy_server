package com.nemsy.nemsy_server.service.user.dto.request;

import com.nemsy.nemsy_server.controller.user.dto.request.UserReqDto;
import com.nemsy.nemsy_server.domain.user.User;

public class UserRequestDto {

    public static User toEntity(String id, UserReqDto userReqDto) {
        String nickname = userReqDto.getNickname();
        return User.newInstance(id, nickname);
    }
}
