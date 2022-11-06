package com.nemsy.nemsy_server.service.comment_law.dto.request;

import com.nemsy.nemsy_server.controller.comment_law.dto.request.CommentReqDto;
import com.nemsy.nemsy_server.domain.comment_law.CommentLaw;
import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.user.User;

public class CommentLawRequestDto {
    public static CommentLaw toEntity(Law law, User author, CommentReqDto commentReqDto) {
        String content = commentReqDto.getContent();
        return CommentLaw.newInstance(law, author, content);
    }
}
