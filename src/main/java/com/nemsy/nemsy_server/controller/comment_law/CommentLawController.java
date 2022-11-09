package com.nemsy.nemsy_server.controller.comment_law;

import com.nemsy.nemsy_server.controller.comment_law.dto.request.CommentReqDto;
import com.nemsy.nemsy_server.service.comment_law.CommentLawService;
import com.nemsy.nemsy_server.service.comment_law.dto.response.CommentLawResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class CommentLawController {

    private CommentLawService commentLawService;
    @ApiOperation(value="123")
    @PostMapping(path = "/bill/{billId}/comments", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void writeComment(@PathVariable String billId, @RequestParam String authorId, @RequestBody CommentReqDto commentReqDto) {
        commentLawService.writeComment(billId, authorId, commentReqDto);
    }

    @GetMapping(path = "/bill/${billId}/comments")
    public ArrayList<CommentLawResponseDto> getComments(@PathVariable String billId) {
        return commentLawService.getComments(billId);
    }
}
