package com.nemsy.nemsy_server.service.law;

import com.nemsy.nemsy_server.controller.law.dto.request.LawReqDto;
import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.law.LawRepository;
import com.nemsy.nemsy_server.service.law.dto.request.LawRequestDto;
import com.nemsy.nemsy_server.service.law.dto.response.LawResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LawService {
    private final LawRepository lawRepository;

    // find bill
    @Transactional
    public LawResponseDto getBillCommunity(String billId, LawReqDto lawReqDto) {
        Law law = lawRepository.findById(billId).orElseGet(() -> {
            String newBillId = createBillCommunity(lawReqDto);
            return lawRepository.findById(newBillId).orElseThrow(()-> new IllegalArgumentException("새로운 소통창 생성에 실패 했습니다."));
        });

        return LawResponseDto.of(law);
//        Optional<Law> law = lawRepository.findById(billId);
//
//        if (law.isPresent()){
//            return LawResponseDto.of(law.get());
//        }
//        Law saveLaw = lawRepository.save(Law.newInstance(LawReqDto));
//        return LawResponseDto.of(saveLaw);


    }

    @Transactional
    public String createBillCommunity(LawReqDto lawReqDto) {
        Law law = LawRequestDto.toEntity(lawReqDto);
        lawRepository.save(law);
        return law.getId();
    }


}
