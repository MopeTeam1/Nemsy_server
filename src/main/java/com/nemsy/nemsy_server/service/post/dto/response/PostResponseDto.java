package com.nemsy.nemsy_server.service.post.dto.response;

import com.nemsy.nemsy_server.domain.post.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private Long postId;
    private String authorId;
    private String authorNickname;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int likeCount;

    public static PostResponseDto of(Post post) {
        return new PostResponseDto(post);
    }

    private PostResponseDto(Post post) {
        this.postId = post.getId();
        this.authorId = post.getAuthor().getId();
        this.authorNickname = post.getAuthor().getNickname();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.likeCount = post.getLikeCount();
    }
}
