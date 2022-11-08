package com.nemsy.nemsy_server.service.law;

import com.nemsy.nemsy_server.controller.law.dto.request.LawReqDto;
import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.law.LawRepository;
import com.nemsy.nemsy_server.service.law.dto.request.LawRequestDto;
import com.nemsy.nemsy_server.service.law.dto.response.LawResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LawService {
    private final LawRepository lawRepository;

    // find bill
    public LawResponseDto getBillCommunity(String billId, LawReqDto lawReqDto) {
        Law law = lawRepository.findById(billId).orElse(() -> {
            return createBillCommunity(billId, lawReqDto);
        });
        return LawResponseDto.of(law);
    }

    public LawResponseDto createBillCommunity(String billId, LawReqDto lawReqDto) {
        Law law = LawRequestDto.toEntity(lawReqDto);
        return
    }
}
