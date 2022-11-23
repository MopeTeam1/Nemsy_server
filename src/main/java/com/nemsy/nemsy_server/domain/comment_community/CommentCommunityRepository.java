package com.nemsy.nemsy_server.domain.comment_community;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentCommunityRepository extends JpaRepository<CommentCommunity, Long> {
    List<CommentCommunity> findCommentCommunityByPostId(Long postId);
}
