package com.nemsy.nemsy_server.domain.comment_law;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentLawRepository extends JpaRepository<CommentLaw, Long> {
}
