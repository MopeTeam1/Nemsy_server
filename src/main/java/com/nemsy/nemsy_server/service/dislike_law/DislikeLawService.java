package com.nemsy.nemsy_server.service.dislike_law;

import com.nemsy.nemsy_server.domain.dislike_law.DislikeLaw;
import com.nemsy.nemsy_server.domain.dislike_law.DislikeLawRepository;
import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.law.LawRepository;
import com.nemsy.nemsy_server.domain.user.User;
import com.nemsy.nemsy_server.domain.user.UserRepository;
import com.nemsy.nemsy_server.service.dislike_law.dto.request.DislikeLawRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DislikeLawService {
    private final DislikeLawRepository dislikeLawRepository;
    private final LawRepository lawRepository;
    private final UserRepository userRepository;

    @Transactional
    public int dislikeLaw(final String billId, final String userId) {
        Law law = lawRepository.findById(billId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 bill id 입니다."));
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 user id 입니다."));
        dislikeLawRepository.save(DislikeLawRequestDto.toEntity(law, user));
        int likeCount = dislikeLawRepository.countByLawId(billId);
        updateBillDislikeCount(billId, likeCount);
        return likeCount;
    }

    @Transactional
    public int unDislikeLaw(final String billId, final String userId) {
        dislikeLawRepository.unDislikeLaw(billId, userId);
        int likeCount = dislikeLawRepository.countByLawId(billId);
        updateBillDislikeCount(billId, likeCount);
        return likeCount;
    }

    public void updateBillDislikeCount(String billId, int likeCount) {
        Law law = lawRepository.findById(billId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 bill id 입니다."));
        law.setLikeCount(likeCount);
        lawRepository.save(law);
    }

    public boolean isDislikedLaw(final String billId, final String userId) {
        DislikeLaw dislikeLaw = dislikeLawRepository.findByLawIdAndUserId(billId, userId);
        return !Objects.isNull(dislikeLaw);
    }
}
