package com.nemsy.nemsy_server.domain.comment_law;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CommentLawRepository extends JpaRepository<CommentLaw, Long> {
    List<CommentLaw> findCommentLawByLawId(String billId);
}
