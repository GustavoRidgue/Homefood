package com.ridgue.homefood.usecase.client;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.usecase.notify.EmailService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ActivateClientUseCase {
    private final EmailService notifier;

    public void activate(ClientEntity clientEntity) {
        clientEntity.setActive(true);
        notifier.notify(clientEntity, "You are now registered in Homefood!");
    }
}
