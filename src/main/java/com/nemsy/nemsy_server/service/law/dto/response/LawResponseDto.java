package com.nemsy.nemsy_server.service.law.dto.response;

import com.nemsy.nemsy_server.domain.law.Law;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LawResponseDto {
    private String billId;
    private int likeCount;
    private int dislikeCount;

    public static LawResponseDto of(Law law) {
        return new LawResponseDto(law);
    }

    private LawResponseDto(final Law law) {
        this.billId = law.getId();
        this.likeCount = law.getLikeCount();
        this.dislikeCount = law.getDislikeCount();
    }
}
