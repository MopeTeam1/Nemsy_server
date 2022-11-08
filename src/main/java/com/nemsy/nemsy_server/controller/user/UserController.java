package com.nemsy.nemsy_server.controller.user;

import com.nemsy.nemsy_server.controller.comment_law.dto.request.CommentReqDto;
import com.nemsy.nemsy_server.controller.user.dto.request.UserReqDto;
import com.nemsy.nemsy_server.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private UserService userService;
    @PostMapping
    public void signUp(@RequestParam String userId, @RequestBody UserReqDto userReqDto) {
        userService.signUp(userId, userReqDto);
    }
}
