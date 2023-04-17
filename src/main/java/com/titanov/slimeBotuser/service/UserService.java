package com.titanov.slimeBotuser.service;

import com.titanov.slimeBotuser.data.entity.User;
import com.titanov.slimeBotuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void registerUser(User user) {
        userRepository.save(user);
    }

}
