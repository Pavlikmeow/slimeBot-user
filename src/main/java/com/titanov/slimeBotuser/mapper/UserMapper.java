package com.titanov.slimeBotuser.mapper;

import com.titanov.slimeBotuser.data.dto.PetNotificationReadyUser;
import com.titanov.slimeBotuser.data.dto.SystemUser;
import com.titanov.slimeBotuser.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "telegramId", source = "id")
    User mapToUser(SystemUser systemUser);

    PetNotificationReadyUser mapToNotificationReadyUser(User user);
}
