package com.nemsy.nemsy_server.domain.like_law;

import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.user.User;

import javax.persistence.*;

@Entity
public class LikeLaw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Law law;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User User;

}