package com.titanov.slimeBotuser.facade;

import com.titanov.slimeBotuser.client.TelegramClient;
import com.titanov.slimeBotuser.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationFacade {
    private final TelegramClient telegramClient;
    private final UserService userService;

    public void createAndSendPetNotificationRequest() {
        var petNotificationRequest = userService.createPetNotificationRequest();
        telegramClient.sendPetNotification(petNotificationRequest);
    }

}
