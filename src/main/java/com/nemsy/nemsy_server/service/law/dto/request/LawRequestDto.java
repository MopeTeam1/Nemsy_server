package com.nemsy.nemsy_server.service.law.dto.request;

import com.nemsy.nemsy_server.controller.law.dto.request.LawReqDto;
import com.nemsy.nemsy_server.domain.law.Law;

public class LawRequestDto {

    public static Law toEntity(String billId) {
        return Law.newInstance(billId);
    }
}
