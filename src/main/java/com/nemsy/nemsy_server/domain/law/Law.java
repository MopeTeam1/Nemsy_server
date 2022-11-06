package com.nemsy.nemsy_server.domain.law;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Entity
public class Law {
    @Id @Column(name = "bill_id")
    private String id;
    @Column(columnDefinition = "TEXT")
    private String detailLink;
    @Column(columnDefinition = "TEXT")
    private String billName;
    @Column(columnDefinition = "TEXT")
    private String committee;
    @Column(columnDefinition = "TEXT")
    private String procResult;
    // TODO age String 맞아?
    @Column(columnDefinition = "TEXT")
    private String age;
    @Column(columnDefinition = "TEXT")
    private String publProposer;
    @Column
    private LocalDate proposeDt;
    @Column(columnDefinition = "TEXT")
    private String rstProposer;
    @Column
    private String author;
    @Column(columnDefinition = "bigint")
    private int likeCount;
    @Column(columnDefinition = "bigint")
    private int dislikeCount;



    public Law() {

    }
}