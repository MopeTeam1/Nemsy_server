package com.nemsy.nemsy_server.service.comment_law.dto.response;

import com.nemsy.nemsy_server.domain.comment_law.CommentLaw;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentLawResponseDto {
    private Long id;
    private String content;
    private String userId;
    private String userNickname;
    private String billId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public static CommentLawResponseDto of(CommentLaw commentLaw) {
        return new CommentLawResponseDto(commentLaw);
    }

    private CommentLawResponseDto(final CommentLaw commentLaw) {
        this.id = commentLaw.getId();
        this.content = commentLaw.getContent();
        this.userId = commentLaw.getAuthor().getId();
        this.userNickname = commentLaw.getAuthor().getNickname();
        this.billId = commentLaw.getLaw().getId();
        this.createdAt = commentLaw.getCreatedAt();
        this.modifiedAt = commentLaw.getModifiedAt();
    }
}
