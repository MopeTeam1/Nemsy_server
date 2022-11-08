package com.nemsy.nemsy_server.service.dislike_law.dto.request;

import com.nemsy.nemsy_server.domain.dislike_law.DislikeLaw;
import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.user.User;

public class DislikeLawRequestDto {
    public static DislikeLaw toEntity(Law law, User user) {
        return DislikeLaw.newInstance(law, user);
    }
}
