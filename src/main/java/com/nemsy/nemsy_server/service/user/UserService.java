package com.nemsy.nemsy_server.service.user;

import com.nemsy.nemsy_server.controller.user.dto.request.UserReqDto;
import com.nemsy.nemsy_server.domain.user.User;
import com.nemsy.nemsy_server.domain.user.UserRepository;
import com.nemsy.nemsy_server.service.user.dto.request.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void signUp(final String userId, UserReqDto userReqDto) {
        User newUser = UserRequestDto.toEntity(userId, userReqDto);
        userRepository.save(newUser);
    }

    public void changeNickname(final String userId, UserReqDto userReqDto) {
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("존재하지 않는 bill id 입니다."));
        String newNickname = userReqDto.getNickname();
        user.setNickname(newNickname);
        userRepository.save(user);
    }
}
