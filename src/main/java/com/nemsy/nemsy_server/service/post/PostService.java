package com.nemsy.nemsy_server.service.post;

import com.nemsy.nemsy_server.controller.post.dto.request.PostRequest;
import com.nemsy.nemsy_server.domain.post.Post;
import com.nemsy.nemsy_server.domain.post.PostRepository;
import com.nemsy.nemsy_server.domain.user.User;
import com.nemsy.nemsy_server.domain.user.UserRepository;
import com.nemsy.nemsy_server.service.post.dto.request.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void writePost(final String userId, PostRequest postRequest) {
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 user id 입니다."));
        Post newPost = PostDto.toEntity(user, postRequest);
        postRepository.save(newPost);
    }
}
