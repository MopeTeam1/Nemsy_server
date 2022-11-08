package com.nemsy.nemsy_server.service.like_law;

import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.law.LawRepository;
import com.nemsy.nemsy_server.domain.like_law.LikeLawRepository;
import com.nemsy.nemsy_server.domain.user.User;
import com.nemsy.nemsy_server.domain.user.UserRepository;
import com.nemsy.nemsy_server.service.like_law.dto.request.LikeLawRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LikeLawService {

    private final LikeLawRepository likeLawRepository;
    private final LawRepository lawRepository;
    private final UserRepository userRepository;

    @Transactional
    public int likeLaw(final String billId, final String userId) {
        Law law = lawRepository.findById(billId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 bill id 입니다."));
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 user id 입니다."));
        likeLawRepository.save(LikeLawRequestDto.toEntity(law, user));
        int likeCount = likeLawRepository.countByLawId(billId);
        updateBillLikeCount(billId, likeCount);
        return likeCount;
    }

    public void updateBillLikeCount(String billId, int likeCount) {
        Law law = lawRepository.findById(billId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 bill id 입니다."));
        law.setLikeCount(likeCount);
        lawRepository.save(law);
    }
}
