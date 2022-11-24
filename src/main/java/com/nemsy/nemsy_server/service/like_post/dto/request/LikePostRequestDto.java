package com.nemsy.nemsy_server.service.like_post.dto.request;

import com.nemsy.nemsy_server.domain.like_post.LikePost;
import com.nemsy.nemsy_server.domain.post.Post;
import com.nemsy.nemsy_server.domain.user.User;

public class LikePostRequestDto {
    public static LikePost toEntity(Post post, User user){
        return LikePost.newInstance(post, user);
    }
}
