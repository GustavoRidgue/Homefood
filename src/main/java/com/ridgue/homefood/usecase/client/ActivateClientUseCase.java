package com.ridgue.homefood.usecase.client;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.exceptions.ClientAlreadyActivatedException;
import com.ridgue.homefood.exceptions.InvalidClientFieldException;
import com.ridgue.homefood.http.ws.util.SendEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ActivateClientUseCase {
    private final SendEmail email;

    public void execute(ClientEntity clientEntity, String redirection) {
        if (clientEntity.isActive()) throw new ClientAlreadyActivatedException();

        String registration = (UUID.randomUUID() + String.valueOf(clientEntity.getId())).substring(0,10);

        email.send(
//                clientEntity.getEmail(),
                "guferrari007@gmail.com",
                "Activate account in Homefood.",
                "Hello " + clientEntity.getName() + ", we are happy to see you here with us!\n" +
                "This is your registration code: " + registration + "\n" +
                "To activate your account, go to: " + redirection + " and insert your registration code");

        clientEntity.setRegistration(registration);
    }
}
