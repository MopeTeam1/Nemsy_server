package com.nemsy.nemsy_server.controller.like_law;

import com.nemsy.nemsy_server.service.like_law.LikeLawService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LikeLawController {

    private final LikeLawService likeLawService;

    @ApiOperation("2")
    @PostMapping("/bill/{billId}/{userId}/likes")
    public int likeLaw(@PathVariable String billId, @PathVariable String userId) {
        return likeLawService.likeLaw(billId, userId);
    }

    @ApiOperation("2")
    @DeleteMapping("/bill/{billId}/{userId}/likes")
    public int unlikeLaw(@PathVariable String billId, @PathVariable String userId) {
        return likeLawService.unlikeLaw(billId, userId);
    }

    @ApiOperation("3")
    @GetMapping("/bill/{billId}/{userId}/likes")
    public boolean isLikedLaw(@PathVariable String billId, @PathVariable String userId) {
        return likeLawService.isLikedLaw(billId, userId);
    }
}
