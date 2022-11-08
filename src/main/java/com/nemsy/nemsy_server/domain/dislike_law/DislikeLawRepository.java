package com.nemsy.nemsy_server.domain.dislike_law;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DislikeLawRepository extends JpaRepository<DislikeLaw, Long> {
}
