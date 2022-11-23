package com.nemsy.nemsy_server.controller.comment_community;

import com.nemsy.nemsy_server.controller.comment_community.dto.request.CommentRequest;
import com.nemsy.nemsy_server.service.comment_community.CommentCommunityService;
import com.nemsy.nemsy_server.service.comment_community.dto.response.CommentCommunityResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentCommunityController {
    private final CommentCommunityService commentCommunityService;

    @ApiOperation("커뮤니티 댓글 작성")
    @PostMapping(path = "/board/{postId}/{userId}/comment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void writeCommunityComment(@PathVariable Long postId, @PathVariable String userId, @RequestBody CommentRequest commentRequest) {
        commentCommunityService.writeComment(postId, userId, commentRequest);
    }

    @ApiOperation("커뮤니티 댓글 모두 가져오기")
    @GetMapping(path = "/board/{postId}/comments")
    public List<CommentCommunityResponseDto> getComments(@PathVariable Long postId) {
        return commentCommunityService.getComments(postId);
    }
}
