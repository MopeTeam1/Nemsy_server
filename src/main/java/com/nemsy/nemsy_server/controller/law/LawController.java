package com.nemsy.nemsy_server.controller.law;

import com.nemsy.nemsy_server.controller.law.dto.request.LawReqDto;
import com.nemsy.nemsy_server.service.law.LawService;
import com.nemsy.nemsy_server.service.law.dto.response.LawResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LawController {

    private final LawService lawService;

    // find bill
    @GetMapping({"/bill/{billId}"})
    public LawResponseDto getBillCommunity(@PathVariable String billId, @RequestBody LawReqDto lawReqDto) {
        return this.lawService.getBillCommunity(billId, lawReqDto);
    }

    public LawController(final LawService lawService) {
        this.lawService = lawService;
    }
}
