package com.ridgue.homefood.database.repository.facade;

import com.ridgue.homefood.database.entity.StateEntity;

import java.util.List;

public interface StateRepositoryFacade {
    List<StateEntity> findAll();
    StateEntity findById(Long id);
    long create(StateEntity clientEntity);
    void deleteById(Long id);
}
