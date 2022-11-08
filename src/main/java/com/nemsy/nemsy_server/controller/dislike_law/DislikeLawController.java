package com.nemsy.nemsy_server.controller.dislike_law;

import com.nemsy.nemsy_server.service.dislike_law.DislikeLawService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DislikeLawController {

    private final DislikeLawService dislikeLawService;

    @PostMapping("/bill/${billId}/dislikes")
    public int dislikeLaw(@PathVariable String billId, @RequestParam String userId) {
        return dislikeLawService.dislikeLaw(billId, userId);
    }

    @DeleteMapping("/bill/${billId}/dislikes")
    public int unDislikeLaw(@PathVariable String billId, @RequestParam String userId) {
        return dislikeLawService.unDislikeLaw(billId, userId);
    }

    @GetMapping("/bill/${billId}/dislikes")
    public boolean isDislikedLaw(@PathVariable String billId, @RequestParam String userId) {
        return dislikeLawService.isDislikedLaw(billId, userId);
    }
}
