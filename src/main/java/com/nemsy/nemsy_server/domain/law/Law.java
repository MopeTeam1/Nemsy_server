package com.nemsy.nemsy_server.domain.law;

import com.nemsy.nemsy_server.controller.law.dto.request.LawReqDto;
import com.nemsy.nemsy_server.domain.comment_law.CommentLaw;
import com.nemsy.nemsy_server.domain.user.User;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Entity
public class Law {
    @Id @Column(name = "bill_id")
    private String id;
    @Column
    private String detailLink;
    @Column
    private String billName;
    @Column
    private String committee;
    @Column
    private String procResult;
    // TODO age String 맞아?
    @Column
    private String age;
    @Column
    private String publProposer;
    @Column
    private LocalDate proposeDt;
    @Column
    private String rstProposer;
    @Column
    private String author;
    @Column
    private int likeCount;
    @Column
    private int dislikeCount;


    private Law(LawReqDto lawReqDto) {
        this.id = lawReqDto.getBillId();
        this.detailLink = lawReqDto.getDetailLink();
        this.billName = lawReqDto.getBillName();
        this.committee = lawReqDto.getCommittee();
        this.procResult = lawReqDto.getProcResult();
        this.age = lawReqDto.getAge();
        this.publProposer = lawReqDto.getPublProposer();
        this.proposeDt = lawReqDto.getProposeDt();
        this.rstProposer = lawReqDto.getRstProposer();
        this.author = lawReqDto.getAuthor();
        this.likeCount = 0;
        this.dislikeCount = 0;
    }

    public static Law newInstance(LawReqDto lawReqDto) {
        return new Law(lawReqDto);
    }

    public Law() {

    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }
}