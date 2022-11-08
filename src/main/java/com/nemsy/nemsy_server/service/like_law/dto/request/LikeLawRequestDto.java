package com.nemsy.nemsy_server.service.like_law.dto.request;

import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.like_law.LikeLaw;
import com.nemsy.nemsy_server.domain.user.User;

public class LikeLawRequestDto {

    public static LikeLaw toEntity(Law law, User user) {
        return LikeLaw.newInstance(law, user);
    }
}
