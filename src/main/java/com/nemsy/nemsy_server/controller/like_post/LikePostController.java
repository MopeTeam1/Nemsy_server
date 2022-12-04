package com.nemsy.nemsy_server.controller.like_post;

import com.nemsy.nemsy_server.dto.common_dto.LikeRequestDto;
import com.nemsy.nemsy_server.service.like_post.LikePostService;
import com.nemsy.nemsy_server.service.like_post.dto.response.LikePostResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LikePostController {

    private final LikePostService likePostService;

    @ApiOperation("게시글 좋아요")
    @PostMapping("/board/{postId}/{userId}/likes")
    public int likePost(@PathVariable Long postId, @PathVariable String userId, @RequestBody LikeRequestDto likeRequestDto) {
        return likePostService.likePost(postId, userId);
    }

    @ApiOperation("게시글 좋아요 취소")
    @DeleteMapping("/board/{postId}/{userId}/likes")
    public int unLikePost(@PathVariable Long postId, @PathVariable String userId) {
        return likePostService.unlikePost(postId, userId);
    }

    @ApiOperation("게시글 좋아요 여부 가져오기")
    @GetMapping("/board/{postId}/{userId}/likes")
    public LikePostResponseDto isPostLiked(@PathVariable Long postId, @PathVariable String userId) {
        return likePostService.isPostLiked(postId, userId);
    }
}
