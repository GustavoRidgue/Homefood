package com.ridgue.homefood.database.repository.impl;

import com.ridgue.homefood.database.entity.CityEntity;
import com.ridgue.homefood.database.entity.CountryEntity;
import com.ridgue.homefood.database.repository.CityRepository;
import com.ridgue.homefood.database.repository.CountryRepository;
import com.ridgue.homefood.database.repository.facade.CityRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.CountryRepositoryFacade;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class CountryRepositoryFacadeImpl implements CountryRepositoryFacade {
    private final CountryRepository countryRepository;

    @Transactional(readOnly = true)
    public List<CountryEntity> findAll() {
        return countryRepository.findAll();
    }

    public CountryEntity findById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    public long create(CountryEntity city) {
        return countryRepository.save(city).getId();
    }

    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
