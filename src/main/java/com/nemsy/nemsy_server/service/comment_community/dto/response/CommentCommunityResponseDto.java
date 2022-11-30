package com.nemsy.nemsy_server.service.comment_community.dto.response;

import com.nemsy.nemsy_server.domain.comment_community.CommentCommunity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentCommunityResponseDto {
    private Long id;
    private String content;
    private String userId;
    private String userNickname;
    private Long postId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static CommentCommunityResponseDto of(CommentCommunity commentCommunity) {
        return new CommentCommunityResponseDto(commentCommunity);
    }

    private CommentCommunityResponseDto(final CommentCommunity commentCommunity) {
        this.id = commentCommunity.getId();
        this.content = commentCommunity.getContent();
        this.userId = commentCommunity.getAuthor().getId();
        this.userNickname = commentCommunity.getAuthor().getNickname();
        this.postId = commentCommunity.getPost().getId();
        this.createdAt = commentCommunity.getCreatedAt();
        this.modifiedAt = commentCommunity.getModifiedAt();
    }
}
