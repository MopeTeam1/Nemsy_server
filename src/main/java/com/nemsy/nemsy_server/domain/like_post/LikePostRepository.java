package com.nemsy.nemsy_server.domain.like_post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikePostRepository extends JpaRepository<LikePost, Long> {

    int countByPostId(Long postId);


    @Modifying
    @Query(value = "DELETE FROM like_post WHERE post_id = :billId AND user_id = :userId", nativeQuery = true)
    void unlikePost(Long billId, String userId);

    LikePost findByPostIdAndUserId(Long postId, String userId);
}
