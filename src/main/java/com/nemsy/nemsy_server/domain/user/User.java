package com.nemsy.nemsy_server.domain.user;

import javax.persistence.*;

@Entity
public class User {
    @Id @Column(name = "user_id")
    private String id;
    @Column
    private String nickname;

    // TODO 생성자 어떻게 할 지. firebase랑 연동하는 부분

    public static User newInstance(final String id, String nickname) {
        return new User(id, nickname);
    }

    private User(final String id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public User() {

    }
}