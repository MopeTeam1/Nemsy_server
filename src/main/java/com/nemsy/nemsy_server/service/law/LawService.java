package com.nemsy.nemsy_server.service.law;

import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.law.LawRepository;
import com.nemsy.nemsy_server.service.law.dto.LawResponseDto;
import org.springframework.stereotype.Service;

@Service
public class LawService {
    private final LawRepository lawRepository;

    // find bill
    public LawResponseDto getLaw(String billId) {
        Law law = this.lawRepository.findById(billId).orElseThrow(() -> {
            return new IllegalArgumentException("없는 법률안입니다.");
        });
        return LawResponseDto.of(law);
    }

//    public

    public LawService(final LawRepository lawRepository) {
        this.lawRepository = lawRepository;
    }
}
