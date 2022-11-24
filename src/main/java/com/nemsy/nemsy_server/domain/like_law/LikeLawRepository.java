package com.nemsy.nemsy_server.domain.like_law;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeLawRepository extends JpaRepository<LikeLaw, Long> {
    int countByLawId(String billId);


    @Modifying
    @Query(value = "DELETE FROM like_law WHERE bill_id = :billId AND user_id = :userId", nativeQuery = true)
    void unlikeLaw(String billId, String userId);
    //    @Query(value = "DELETE FROM LikeLaw l WHERE  l.law = :billId AND l.user = :userId")

    LikeLaw findByLawIdAndUserId(String billId, String userId);
}
