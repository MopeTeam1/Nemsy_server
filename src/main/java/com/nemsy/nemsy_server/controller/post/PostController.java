package com.nemsy.nemsy_server.controller.post;

import com.nemsy.nemsy_server.controller.post.dto.request.PostRequest;
import com.nemsy.nemsy_server.service.post.PostService;
import com.nemsy.nemsy_server.service.post.dto.response.PostListResDto;
import com.nemsy.nemsy_server.service.post.dto.response.PostResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @ApiOperation("커뮤니티 게시물 작성")
    @PostMapping(path = "/board/{userId}/post", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void writePost(@PathVariable String userId, @RequestBody PostRequest postRequest) {
        postService.writePost(userId, postRequest);
    }

    @ApiOperation("커뮤니티 게시글 페이지네이션")
    @GetMapping("/board")
    public PostListResDto getPosts(@PageableDefault(size=6) Pageable pageable) {
        return postService.getPosts(pageable);
    }

    @ApiOperation("커뮤니티 게시물 조회")
    @GetMapping("/board/{postId}")
    public PostResponseDto getPost(@PathVariable Long postId) {
        return postService.getPost(postId);
    }
}
