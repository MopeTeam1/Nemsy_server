package com.nemsy.nemsy_server.controller.like_law;

import com.nemsy.nemsy_server.service.like_law.LikeLawService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LikeLawController {

    private final LikeLawService likeLawService;
    @ApiOperation("법률안 좋아요")
    @PostMapping("/bill/{billId}/{userId}/likes")
    public int likeLaw(@PathVariable String billId, @PathVariable String userId) {
        return likeLawService.likeLaw(billId, userId);
    }
    @ApiOperation("법률안 좋아요 취소")
    @DeleteMapping("/bill/{billId}/{userId}/likes")
    public int unlikeLaw(@PathVariable String billId, @PathVariable String userId) {
        return likeLawService.unlikeLaw(billId, userId);
    }

    @ApiOperation("법률안 좋아요 여부 가져오기")
    @GetMapping("/bill/{billId}/{userId}/likes")
    public boolean isLawLiked(@PathVariable String billId, @PathVariable String userId) {
        return likeLawService.isLawLiked(billId, userId);
    }
}
