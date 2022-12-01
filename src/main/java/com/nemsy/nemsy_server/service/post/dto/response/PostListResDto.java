package com.nemsy.nemsy_server.service.post.dto.response;

import com.nemsy.nemsy_server.domain.post.Post;
import lombok.Getter;

import java.util.List;

@Getter
public class PostListResDto {
    private Long postCnt;
    private List<PostResponseDto> postList;

    public static PostListResDto of(Long postCnt, List<PostResponseDto> postList) {
        return new PostListResDto(postCnt, postList);
    }

    private PostListResDto(Long postCnt, List<PostResponseDto> postList) {
        this.postCnt = postCnt;
        this.postList = postList;
    }
}
