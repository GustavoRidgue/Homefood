package com.ridgue.homefood.database.repository.impl;

import com.ridgue.homefood.database.entity.StateEntity;
import com.ridgue.homefood.database.repository.StateRepository;
import com.ridgue.homefood.database.repository.facade.StateRepositoryFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class StateClientRepositoryFacadeImpl implements StateRepositoryFacade {
    private final StateRepository stateRepository;

    @Transactional(readOnly = true)
    public List<StateEntity> findAll() {
        return stateRepository.findAll();
    }

    public StateEntity findById(Long id) {
        return stateRepository.findById(id).orElse(null);
    }

    public long create(StateEntity state) {
        return stateRepository.save(state).getId();
    }

    public void deleteById(Long id) {
        stateRepository.deleteById(id);
    }
}
