package com.titanov.slimeBotuser.scheduler;

import com.titanov.slimeBotuser.facade.NotificationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationScheduler {

    private final NotificationFacade notificationFacade;

    @Scheduled(cron = "0 0 12 * * *", zone = "Europe/Moscow")
    public void sendPetNotification() {
        notificationFacade.createAndSendPetNotificationRequest();
    }
}
