package com.nemsy.nemsy_server.domain.post;

import com.nemsy.nemsy_server.domain.common.BaseTimeEntity;
import com.nemsy.nemsy_server.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long id;
    @Column
    private String title;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
    @Column
    private String content;
    @Column
    private int likeCount;

    public Post(String title, User author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.likeCount = 0;
    }

    public static Post newInstance(String title, User author, String content) {
        return new Post(title, author, content);
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
