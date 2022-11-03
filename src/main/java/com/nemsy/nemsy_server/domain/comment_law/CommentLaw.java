package com.nemsy.nemsy_server.domain.comment_law;

import com.nemsy.nemsy_server.domain.common.BaseTimeEntity;
import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.user.User;

import javax.persistence.*;

@Entity
public class CommentLaw extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Law law;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
