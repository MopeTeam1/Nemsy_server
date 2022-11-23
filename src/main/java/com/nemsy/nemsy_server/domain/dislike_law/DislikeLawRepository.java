package com.nemsy.nemsy_server.domain.dislike_law;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DislikeLawRepository extends JpaRepository<DislikeLaw, Long> {

    int countByLawId(String billId);

    @Modifying
    @Query(value = "DELETE FROM dislike_law WHERE bill_id = :billId AND user_id = :userId", nativeQuery = true)

    void unDislikeLaw(String billId, String userId);

    DislikeLaw findByLawIdAndUserId(String billId, String userId);
}
