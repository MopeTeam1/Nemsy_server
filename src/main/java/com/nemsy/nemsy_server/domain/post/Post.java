package com.nemsy.nemsy_server.domain.post;

import com.nemsy.nemsy_server.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Post {
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

    public Post(long postId, String title, User author, String content) {
        this.id = postId;
        this.title = title;
        this.author = author;
        this.content = content;
        this.likeCount = 0;
    }

    public static Post newInstance(long postId, String title, User author, String content) {
        return new Post(postId, title, author, content);
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
