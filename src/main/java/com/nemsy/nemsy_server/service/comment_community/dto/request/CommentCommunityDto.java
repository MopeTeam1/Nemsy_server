package com.nemsy.nemsy_server.service.comment_community.dto.request;

import com.nemsy.nemsy_server.controller.comment_community.dto.request.CommentRequest;
import com.nemsy.nemsy_server.domain.comment_community.CommentCommunity;
import com.nemsy.nemsy_server.domain.post.Post;
import com.nemsy.nemsy_server.domain.user.User;

public class CommentCommunityDto {
    public static CommentCommunity toEntity(Post post, User author, CommentRequest commentRequest) {
        String content = commentRequest.getContent();
        return CommentCommunity.newInstance(post, author, content);
    }
}
