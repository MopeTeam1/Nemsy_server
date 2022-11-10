package com.nemsy.nemsy_server.controller.dislike_law;

import com.nemsy.nemsy_server.service.dislike_law.DislikeLawService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DislikeLawController {

    private final DislikeLawService dislikeLawService;

    @ApiOperation("dislike")
    @PostMapping("/bill/{billId}/{userId}/dislikes")
    public int dislikeLaw(@PathVariable String billId, @PathVariable String userId) {
        return dislikeLawService.dislikeLaw(billId, userId);
    }
    @ApiOperation("deleteDislike")
    @DeleteMapping("/bill/{billId}/{userId}/dislikes")
    public int unDislikeLaw(@PathVariable String billId, @PathVariable String userId) {
        return dislikeLawService.unDislikeLaw(billId, userId);
    }

    @ApiOperation("isDisliked")
    @GetMapping("/bill/{billId}/{userId}/dislikes")
    public boolean isDislikedLaw(@PathVariable String billId, @PathVariable String userId) {
        return dislikeLawService.isDislikedLaw(billId, userId);
    }
}
