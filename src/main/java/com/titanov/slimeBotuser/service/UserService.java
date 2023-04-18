package com.titanov.slimeBotuser.service;

import com.titanov.slimeBotuser.data.dto.PetNotificationReadyUser;
import com.titanov.slimeBotuser.data.dto.PetNotificationRequest;
import com.titanov.slimeBotuser.data.entity.User;
import com.titanov.slimeBotuser.mapper.UserMapper;
import com.titanov.slimeBotuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void registerUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public PetNotificationRequest createPetNotificationRequest() {
        List<User> userList = userRepository.findAll();
        var notificationReadyUserList = userList
                .stream()
                .map(this::createNotificationReadyUser)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return new PetNotificationRequest(notificationReadyUserList);
    }

    public PetNotificationReadyUser createNotificationReadyUser(User user) {
        try {
            return userMapper.mapToNotificationReadyUser(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

}
