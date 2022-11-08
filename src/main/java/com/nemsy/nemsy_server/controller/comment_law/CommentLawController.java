package com.nemsy.nemsy_server.controller.comment_law;

import com.nemsy.nemsy_server.controller.comment_law.dto.request.CommentReqDto;
import com.nemsy.nemsy_server.service.comment_law.CommentLawService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentLawController {

    private CommentLawService commentLawService;
    @PostMapping(path = "/bill/{billId}/comments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void writeComment(@PathVariable String billId, @RequestParam String authorId, @RequestBody CommentReqDto commentReqDto) {
        commentLawService.writeComment(billId, authorId, commentReqDto);
    }

//    public CommentLawController(final CommentLawService commentLawService) {
//        this.commentLawService = commentLawService;
//    }
}
