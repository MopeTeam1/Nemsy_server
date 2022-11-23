package com.nemsy.nemsy_server.domain.like_post;

import com.nemsy.nemsy_server.domain.post.Post;
import com.nemsy.nemsy_server.domain.user.User;

import javax.persistence.*;

@Entity
public class LikePost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LikePost(final Post post, final User user) {
        this.post = post;
        this.user = user;
    }

    public LikePost(){}

    public static LikePost newInstance(final Post post, final User user) {
        return new LikePost(post, user);
    }
}
