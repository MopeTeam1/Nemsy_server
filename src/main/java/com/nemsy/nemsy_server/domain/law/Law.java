package com.nemsy.nemsy_server.domain.law;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Entity
public class Law {
    @Id @Column(name = "bill_id")
    private String id;
    @Column
    private int likeCount;
    @Column
    private int dislikeCount;

    private Law(String billId) {
        this.id = billId;
        this.likeCount = 0;
        this.dislikeCount = 0;
    }

    public static Law newInstance(String billId) {
        return new Law(billId);
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