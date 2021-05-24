package com.ridgue.homefood.database.repository.impl;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.repository.ClientRepository;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
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

    public void create(ClientEntity clientEntity) {
        clientRepository.save(clientEntity);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
