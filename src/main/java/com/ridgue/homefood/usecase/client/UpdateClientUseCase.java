package com.ridgue.homefood.usecase.client;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.http.domain.request.ClientRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateClientUseCase {
    private final ClientRepositoryFacade clientRepositoryFacade;

    public void execute(Long id, ClientRequest clientRequest) {
        ClientEntity clientEntity = clientRepositoryFacade.findById(id);
        clientEntity.setName(clientRequest.getName());
        clientEntity.setPhoneNumber(clientRequest.getPhoneNumber());
        clientEntity.setEmail(clientRequest.getEmail());
        clientEntity.setAge(clientRequest.getAge());
        clientEntity.setActive(true);
    }
}
