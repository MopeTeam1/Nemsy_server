package com.nemsy.nemsy_server.service.comment_law;

import com.nemsy.nemsy_server.controller.comment_law.dto.request.CommentReqDto;
import com.nemsy.nemsy_server.domain.comment_law.CommentLaw;
import com.nemsy.nemsy_server.domain.comment_law.CommentLawRepository;
import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.law.LawRepository;
import com.nemsy.nemsy_server.domain.user.User;
import com.nemsy.nemsy_server.domain.user.UserRepository;
import com.nemsy.nemsy_server.service.comment_law.dto.request.CommentLawRequestDto;
import org.springframework.stereotype.Service;

@Service
public class CommentLawService {
    private final CommentLawRepository commentLawRepository;
    private final LawRepository lawRepository;
    private final UserRepository userRepository;

    public boolean writeComment(String billId, String authorId, CommentReqDto commentReqDto) {
        Law law = lawRepository.findById(billId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 bill id 입니다."));
        User author = userRepository.findById(authorId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 user id 입니다."));
        CommentLaw newComment = CommentLawRequestDto.toEntity(law, author, commentReqDto);
        commentLawRepository.save(newComment);
        return true;
    }
    public CommentLawService(final CommentLawRepository commentLawRepository,
                             final LawRepository lawRepository,
                             final UserRepository userRepository) {
        this.commentLawRepository = commentLawRepository;
        this.lawRepository = lawRepository;
        this.userRepository = userRepository;
    }
}
