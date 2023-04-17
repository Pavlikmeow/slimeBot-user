package com.titanov.slimeBotuser.controller;

import com.titanov.slimeBotuser.data.dto.SystemUser;
import com.titanov.slimeBotuser.data.entity.User;
import com.titanov.slimeBotuser.mapper.UserMapper;
import com.titanov.slimeBotuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    void registerUser(@RequestBody SystemUser systemUser) {
        User user = userMapper.mapToUser(systemUser);
        userService.registerUser(user);
    }
}
