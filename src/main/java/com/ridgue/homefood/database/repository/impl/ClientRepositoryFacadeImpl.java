package com.ridgue.homefood.database.repository.impl;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.repository.ClientRepository;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.exceptions.ClientAlreadyActivatedException;
import com.ridgue.homefood.exceptions.ClientNotFoundException;
import com.ridgue.homefood.exceptions.InvalidClientTokenException;
import com.ridgue.homefood.http.domain.request.ClientRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class ClientRepositoryFacadeImpl implements ClientRepositoryFacade {
    private final ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<ClientEntity> findAll() {
        return clientRepository.findAll();
    }

    public ClientEntity findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public long create(ClientEntity clientEntity) {
        return clientRepository.save(clientEntity).getId();
    }

    public ClientEntity updateById(Long id, ClientRequest clientRequest) {
        if (!clientRepository.findById(id).isPresent()) throw new ClientNotFoundException();

        ClientEntity clientEntity = clientRepository.findById(id).get();
        clientEntity.setName(clientRequest.getName());
        clientEntity.setPhoneNumber(clientRequest.getPhoneNumber());
        clientEntity.setEmail(clientRequest.getEmail());
        clientEntity.setAge(clientRequest.getAge());
        clientEntity.setActive(true);

        return clientEntity;
    }

    public ClientEntity updateTokenById(Long id, String token) {
        if (!clientRepository.findById(id).isPresent()) throw new ClientNotFoundException();

        ClientEntity clientEntity = clientRepository.findById(id).get();

        if (clientEntity.isActive()) throw new ClientAlreadyActivatedException();

        clientEntity.setToken(token);

        return clientEntity;
    }

    public ClientEntity activate(Long id, String token) {
        if (!clientRepository.findById(id).isPresent()) throw new ClientNotFoundException();

        ClientEntity clientById = clientRepository.findById(id).get();

        if (clientById.isActive()) throw new ClientAlreadyActivatedException();
        if (!token.equals(clientById.getToken())) throw new InvalidClientTokenException();

        clientById.setActive(true);

        return clientById;
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}
