package com.nemsy.nemsy_server.controller.dislike_law;

import com.nemsy.nemsy_server.service.dislike_law.DislikeLawService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DislikeLawController {

    private final DislikeLawService dislikeLawService;

    @ApiOperation("싫어요")
    @PostMapping("/bill/{billId}/{userId}/dislikes")
    public int dislikeLaw(@PathVariable String billId, @PathVariable String userId) {
        return dislikeLawService.dislikeLaw(billId, userId);
    }
    @ApiOperation("싫어요 취소")
    @DeleteMapping("/bill/{billId}/{userId}/dislikes")
    public int unDislikeLaw(@PathVariable String billId, @PathVariable String userId) {
        return dislikeLawService.unDislikeLaw(billId, userId);
    }

    @ApiOperation("싫어요 여부 가져오기")
    @GetMapping("/bill/{billId}/{userId}/dislikes")
    public boolean isLawDisliked(@PathVariable String billId, @PathVariable String userId) {
        return dislikeLawService.isLawDisliked(billId, userId);
    }
}
