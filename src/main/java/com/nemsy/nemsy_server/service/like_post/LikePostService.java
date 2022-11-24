package com.nemsy.nemsy_server.service.like_post;

import com.nemsy.nemsy_server.domain.like_post.LikePost;
import com.nemsy.nemsy_server.domain.like_post.LikePostRepository;
import com.nemsy.nemsy_server.domain.post.Post;
import com.nemsy.nemsy_server.domain.post.PostRepository;
import com.nemsy.nemsy_server.domain.user.User;
import com.nemsy.nemsy_server.domain.user.UserRepository;
import com.nemsy.nemsy_server.service.like_post.dto.request.LikePostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LikePostService {
    
    private final LikePostRepository likePostRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public int likePost(final Long postId, final String userId) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 post id 입니다."));
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 user id 입니다."));
        likePostRepository.save(LikePostRequestDto.toEntity(post, user));
        int likeCount = likePostRepository.countByPostId(postId);
        updatePostLikeCount(postId, likeCount);
        return likeCount;
    }

    @Transactional
    public int unlikePost(final Long postId, final String userId) {
        likePostRepository.unlikePost(postId, userId);
        int likeCount = likePostRepository.countByPostId(postId);
        updatePostLikeCount(postId, likeCount);
        return likeCount;
    }

    public void updatePostLikeCount(Long postId, int likeCount) {
        Post post = postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 post id 입니다.\nupdatePostLikeCount"));
        post.setLikeCount(likeCount);
        postRepository.save(post);
    }

    public boolean isPostLiked(final Long postId, final String userId) {
        LikePost likePost = likePostRepository.findByPostIdAndUserId(postId, userId);
        return !Objects.isNull(likePost);
    }
}
