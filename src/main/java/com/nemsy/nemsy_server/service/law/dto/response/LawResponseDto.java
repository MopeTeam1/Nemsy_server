package com.nemsy.nemsy_server.service.law.dto.response;

import com.nemsy.nemsy_server.domain.law.Law;

import java.time.LocalDate;

public class LawResponseDto {
    private String billId;
    private String detailLink;
    private String billName;
    private String committee;
    private String procResult;
    private String age;
    private String publProposer;
    private LocalDate proposeDt;
    private String rstProposer;
    private String author;
    private int likeCount;
    private int dislikeCount;


    public static LawResponseDto of(Law law) {
        return new LawResponseDto(law);
    }

//    public static LawResponseDto of()

    private LawResponseDto(final Law law) {
        this.billId = law.getId();
        this.detailLink = law.getDetailLink();
        this.committee = law.getCommittee();
        this.procResult = law.getProcResult();
        this.age = law.getAge();
        this.publProposer = law.getPublProposer();
        this.proposeDt = law.getProposeDt();
        this.rstProposer = law.getRstProposer();
        this.author = law.getAuthor();
        this.likeCount = law.getLikeCount();
        this.dislikeCount = law.getDislikeCount();
    }
}
