package com.ridgue.homefood.database.repository.impl;

import com.ridgue.homefood.database.entity.CityEntity;
import com.ridgue.homefood.database.repository.CityRepository;
import com.ridgue.homefood.database.repository.ClientRepository;
import com.ridgue.homefood.database.repository.facade.CityRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class CityRepositoryFacadeImpl implements CityRepositoryFacade {
    private final CityRepository cityRepository;

    @Transactional(readOnly = true)
    public List<CityEntity> findAll() {
        return cityRepository.findAll();
    }

    public CityEntity findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public long create(CityEntity city) {
        return cityRepository.save(city).getId();
    }

    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }
}
