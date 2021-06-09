package com.ridgue.homefood.usecase.client;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.repository.ClientRepository;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.exceptions.ClientAlreadyActivatedException;
import com.ridgue.homefood.exceptions.InvalidClientTokenException;
import com.ridgue.homefood.http.ws.util.SendEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActivateClientCodeUseCase {
    private final ClientRepositoryFacade clientRepositoryFacade;
    private final SendEmail email;

    public ClientEntity execute(Long id, String token) {
        ClientEntity clientById = clientRepositoryFacade.activate(id, token);

        email.send(
                "guferrari007@gmail.com",
                "Account activated successfully in Homefood.",
                "Hello again " + clientById.getName() + ", we are happy to see you here with us!\n" +
                "Your account was registrated and activated successfully \n" +
                "Now you can navigate in our API normally");

        return clientById;
    }
}
