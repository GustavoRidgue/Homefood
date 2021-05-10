package com.ridgue.homefood.http.service.notify;

import com.ridgue.homefood.database.entity.Client;
import com.ridgue.homefood.http.service.client.Email;
import org.springframework.stereotype.Component;

@Component
public class EmailService implements Email {
    @Override
    public void notify(Client client, String message) {
        System.out.printf("Notifying %s through e-mail %s: %s\n",
                client.getName(), client.getEmail(), message);
    }
}
