package com.nemsy.nemsy_server.controller.user;

import com.nemsy.nemsy_server.controller.user.dto.request.UserReqDto;
import com.nemsy.nemsy_server.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @ApiOperation("회원 등록")
    @PostMapping("/user/register/{userId}")
    public void signUp(@PathVariable String userId, @RequestBody UserReqDto userReqDto) {
        userService.signUp(userId, userReqDto);
    }

    @ApiOperation("닉에임 변경")
    @PutMapping("/user/{userId}/nickname")
    public void changeNickname(@PathVariable String userId, @RequestBody UserReqDto userReqDto) {
        userService.changeNickname(userId, userReqDto);
    }

//    @GetMapping("user/test")
//    public void test() {
////        return "test";
//    }
}
