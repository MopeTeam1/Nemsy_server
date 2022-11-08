package com.nemsy.nemsy_server.domain.comment_law;

import com.nemsy.nemsy_server.domain.common.BaseTimeEntity;
import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.user.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CommentLaw extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Law law;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private CommentLaw(final Law law, final User author, String content) {
        this.law = law;
        this.user = author;
        this.content = content;
    }

    public static CommentLaw newInstance(final Law law, final User author, String content) {
        return new CommentLaw(law, author, content);
    }

    public CommentLaw(){};
}
