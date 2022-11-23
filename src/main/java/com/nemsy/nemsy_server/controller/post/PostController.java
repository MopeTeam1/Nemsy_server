package com.nemsy.nemsy_server.controller.post;

import com.nemsy.nemsy_server.controller.post.dto.request.PostRequest;
import com.nemsy.nemsy_server.service.post.PostService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @ApiOperation("커뮤니티 게시물 작성")
    @PostMapping(path = "/board/{userId}/post", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void writePost(@PathVariable String userId, @RequestBody PostRequest postRequest) {
        postService.writePost(userId, postRequest);
    }
}
