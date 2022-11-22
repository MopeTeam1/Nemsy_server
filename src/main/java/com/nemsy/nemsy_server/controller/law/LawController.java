package com.nemsy.nemsy_server.controller.law;

import com.nemsy.nemsy_server.service.law.LawService;
import com.nemsy.nemsy_server.service.law.dto.response.LawResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LawController {

    private final LawService lawService;

    @ApiOperation("법률안 가져오기")
    @GetMapping({"/bill/{billId}"})
    public LawResponseDto getBillCommunity(@PathVariable String billId) {
        return this.lawService.getBillCommunity(billId);
    }
}
