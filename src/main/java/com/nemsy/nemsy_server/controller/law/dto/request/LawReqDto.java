package com.nemsy.nemsy_server.controller.law.dto.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LawReqDto {
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
}
