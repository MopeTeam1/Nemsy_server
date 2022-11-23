package com.nemsy.nemsy_server.domain.comment_community;

import com.nemsy.nemsy_server.domain.common.BaseTimeEntity;
import com.nemsy.nemsy_server.domain.post.Post;
import com.nemsy.nemsy_server.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class CommentCommunity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    private CommentCommunity(final Post post, final User author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
    }

    public static CommentCommunity newInstance(final Post post, final User author, String content) {
        return new CommentCommunity(post, author, content);
    }
}
