package com.ridgue.homefood.usecase.client;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.http.domain.request.ClientRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateClientUseCase {
    private final ClientRepositoryFacade clientRepositoryFacade;

    public long execute(ClientRequest clientRequest) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(clientRequest.getName());
        clientEntity.setPhoneNumber(clientRequest.getPhoneNumber());
        clientEntity.setEmail(clientRequest.getEmail());
        clientEntity.setAge(clientRequest.getAge());

        clientRepositoryFacade.create(clientEntity);

        return clientEntity.getId();
    }
}
