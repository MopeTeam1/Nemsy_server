package com.nemsy.nemsy_server.service.post;

import com.nemsy.nemsy_server.controller.post.dto.request.PostRequest;
import com.nemsy.nemsy_server.domain.post.Post;
import com.nemsy.nemsy_server.domain.post.PostRepository;
import com.nemsy.nemsy_server.domain.user.User;
import com.nemsy.nemsy_server.domain.user.UserRepository;
import com.nemsy.nemsy_server.service.post.dto.request.PostDto;
import com.nemsy.nemsy_server.service.post.dto.response.PostListResDto;
import com.nemsy.nemsy_server.service.post.dto.response.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public PostListResDto getPosts(Pageable pageable) {
        Page<Post> posts = postRepository.findAllByOrderByCreatedAtDesc(pageable);
        List<PostResponseDto> postList = posts.stream()
                                    .map(PostResponseDto::of)
                                    .collect(Collectors.toList());
        Long postCnt = postRepository.count();
        return PostListResDto.of(postCnt, postList);
    }

    public PostResponseDto getPost(final Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 post id 입니다."));
        return PostResponseDto.of(post);
    }
}
