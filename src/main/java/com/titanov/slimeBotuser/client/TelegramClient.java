package com.titanov.slimeBotuser.client;

import com.titanov.slimeBotuser.data.dto.PetNotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "slimeBot-telegram", url = "localhost:8080/user")
public interface TelegramClient {

    @PostMapping("/petNotification")
    void sendPetNotification(@RequestBody PetNotificationRequest notificationRequest);
}
