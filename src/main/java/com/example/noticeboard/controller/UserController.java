package com.example.noticeboard.controller;

import com.example.noticeboard.dto.BoardRequestDto;
import com.example.noticeboard.dto.LoginRequestDto;
import com.example.noticeboard.dto.SignupRequestDto;
import com.example.noticeboard.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto requestDto, HttpServletResponse res){
        userService.login(requestDto, res);
        String ok = "로그인 완료";
        return ok;
    }
    //todo 반환할거 생각해보기
    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequestDto requestDto){
        userService.signup(requestDto);
        String ok = "회원가입 완료";
        return ok;
    }
}
