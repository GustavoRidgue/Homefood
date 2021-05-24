package com.ridgue.homefood.database.repository.facade;

import com.ridgue.homefood.database.entity.ClientEntity;

import java.util.List;

public interface ClientRepositoryFacade {
    List<ClientEntity> findAll();
    ClientEntity findById(Long id);
    void create(ClientEntity clientEntity);
    void delete(Long id);
}
