package com.nemsy.nemsy_server.controller.comment_community;

import com.nemsy.nemsy_server.controller.comment_community.dto.request.CommentRequest;
import com.nemsy.nemsy_server.service.comment_community.CommentCommunityService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentCommunityController {
    private final CommentCommunityService commentCommunityService;

    @ApiOperation("커뮤니티 댓글 작성")
    @PostMapping(path = "/board/{postId}/{userId}/comment", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void writeCommunityComment(@PathVariable Long postId, @PathVariable String userId, @RequestBody CommentRequest commentRequest) {
        commentCommunityService.writeComment(postId, userId, commentRequest);
    }
}
