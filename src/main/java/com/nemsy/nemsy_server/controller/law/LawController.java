package com.nemsy.nemsy_server.controller.law;

import com.nemsy.nemsy_server.service.law.LawService;
import com.nemsy.nemsy_server.service.law.dto.response.LawResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LawController {

    private final LawService lawService;

    // find bill
    @GetMapping({"/bill/{billId}"})
    public LawResponseDto getLaw(@PathVariable String billId) {
        return this.lawService.getLaw(billId);
    }

    public LawController(final LawService lawService) {
        this.lawService = lawService;
    }
}
