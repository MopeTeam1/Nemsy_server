package com.nemsy.nemsy_server.service.comment_community;

import com.nemsy.nemsy_server.controller.comment_community.dto.request.CommentRequest;
import com.nemsy.nemsy_server.domain.comment_community.CommentCommunity;
import com.nemsy.nemsy_server.domain.comment_community.CommentCommunityRepository;
import com.nemsy.nemsy_server.domain.post.Post;
import com.nemsy.nemsy_server.domain.post.PostRepository;
import com.nemsy.nemsy_server.domain.user.User;
import com.nemsy.nemsy_server.domain.user.UserRepository;
import com.nemsy.nemsy_server.service.comment_community.dto.request.CommentCommunityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentCommunityService {
    private final CommentCommunityRepository commentCommunityRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    public void writeComment(final Long postId, final String userId, CommentRequest commentRequest) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 post id 입니다."));
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 user id 입니다."));
        CommentCommunity newComment = CommentCommunityDto.toEntity(post, user, commentRequest);
        commentCommunityRepository.save(newComment);
    }
}
