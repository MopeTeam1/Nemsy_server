package com.nemsy.nemsy_server.domain.dislike_law;

import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.user.User;

import javax.persistence.*;

@Entity
public class DislikeLaw {
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
