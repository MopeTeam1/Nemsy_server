package com.nemsy.nemsy_server.domain.comment_law;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CommentLawRepository extends JpaRepository<CommentLaw, Long> {
    ArrayList<CommentLaw> findByLawIdOrderByCreatedAt(String billId);
}
