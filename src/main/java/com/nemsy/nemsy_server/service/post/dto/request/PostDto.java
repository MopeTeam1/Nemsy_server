package com.nemsy.nemsy_server.service.post.dto.request;

import com.nemsy.nemsy_server.controller.post.dto.request.PostRequest;
import com.nemsy.nemsy_server.domain.post.Post;
import com.nemsy.nemsy_server.domain.user.User;

public class PostDto {
    public static Post toEntity(User author, PostRequest postRequest) {
        String title = postRequest.getTitle();
        String content = postRequest.getContent();
        return Post.newInstance(title, author, content);
    }
}
