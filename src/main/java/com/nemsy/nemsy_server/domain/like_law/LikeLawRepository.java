package com.nemsy.nemsy_server.domain.like_law;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeLawRepository extends JpaRepository<LikeLaw, Long> {
}
