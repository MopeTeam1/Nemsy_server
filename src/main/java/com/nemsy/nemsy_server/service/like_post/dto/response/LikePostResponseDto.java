package com.nemsy.nemsy_server.service.like_post.dto.response;

import com.nemsy.nemsy_server.domain.like_post.LikePost;
import lombok.Getter;

import java.util.Objects;

@Getter
public class LikePostResponseDto {
  private int likeCount;

  private boolean isLiked;

  public static LikePostResponseDto of(int likeCount, boolean isLiked) {
      return new LikePostResponseDto(likeCount, isLiked);
  }

  private LikePostResponseDto(int likeCount, boolean isLiked){
      this.likeCount = likeCount;
      this.isLiked = isLiked;
  }
}
