package com.ridgue.homefood.http.service.client;

import com.ridgue.homefood.database.entity.Client;
import com.ridgue.homefood.http.service.notify.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ActivateClientService {
    private final EmailService notifier;

    public void activate(Client client) {
        client.setActive(true);
        notifier.notify(client, "You are now registered in Homefood!");
    }
}
