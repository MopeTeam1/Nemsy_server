package com.nemsy.nemsy_server.service.comment_law;

import com.nemsy.nemsy_server.controller.comment_law.dto.request.CommentReqDto;
import com.nemsy.nemsy_server.domain.comment_law.CommentLaw;
import com.nemsy.nemsy_server.domain.comment_law.CommentLawRepository;
import com.nemsy.nemsy_server.domain.law.Law;
import com.nemsy.nemsy_server.domain.law.LawRepository;
import com.nemsy.nemsy_server.domain.user.User;
import com.nemsy.nemsy_server.domain.user.UserRepository;
import com.nemsy.nemsy_server.service.comment_law.dto.request.CommentLawRequestDto;
import com.nemsy.nemsy_server.service.comment_law.dto.response.CommentLawResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CommentLawService {
    private final CommentLawRepository commentLawRepository;
    private final LawRepository lawRepository;
    private final UserRepository userRepository;

    public void writeComment(final String billId, final String authorId, CommentReqDto commentReqDto) {
        Law law = lawRepository.findById(billId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 bill id 입니다."));
        User author = userRepository.findById(authorId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 user id 입니다."));
        CommentLaw newComment = CommentLawRequestDto.toEntity(law, author, commentReqDto);
        commentLawRepository.save(newComment);
//        return true;
    }

    public ArrayList<CommentLawResponseDto> getComments(final String billId) {
        ArrayList<CommentLaw> commentLawList = commentLawRepository.findByLawIdOrderByCreatedAt(billId);

        ArrayList<CommentLawResponseDto> result = new ArrayList<CommentLawResponseDto>();

        for (CommentLaw commentLaw : commentLawList) {
            CommentLawResponseDto tmp = CommentLawResponseDto.of(commentLaw);
            result.add(tmp);
        }

        return result;
    }
}
