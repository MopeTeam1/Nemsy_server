package com.nemsy.nemsy_server.domain.user;

import javax.persistence.*;

@Entity
public class User {
    @Id @Column(name = "user_id")
    private String id;
    @Column
    private String nickname;

    // TODO 생성자 어떻게 할 지. firebase랑 연동하는 부분
    public User() {

    }
}