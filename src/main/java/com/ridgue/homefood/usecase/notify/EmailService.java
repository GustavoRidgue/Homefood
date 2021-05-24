package com.ridgue.homefood.usecase.notify;

import com.ridgue.homefood.database.entity.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EmailService implements Email {
    private boolean upperCase;
    private String smtp;



    @Override
    public void notify(ClientEntity clientEntity, String message) {
        System.out.printf("Notifying %s through e-mail %s using SMTP %s: %s\n",
                clientEntity.getName(), clientEntity.getEmail(), this.smtp, message);
    }
}
