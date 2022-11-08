package com.nemsy.nemsy_server.controller.like_law;

import com.nemsy.nemsy_server.service.like_law.LikeLawService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class LikeLawController {

    private final LikeLawService likeLawService;

    @PostMapping("/bill/${billId}/likes")
    public int likeLaw(@PathVariable String billId, @RequestParam String userId) {
        return likeLawService.likeLaw(billId, userId);
    }

    @DeleteMapping("/bill/${billId}/likes")
    public int unlikeLaw(@PathVariable String billId, @RequestParam String userId) {
        return likeLawService.unlikeLaw(billId, userId);
    }
}
