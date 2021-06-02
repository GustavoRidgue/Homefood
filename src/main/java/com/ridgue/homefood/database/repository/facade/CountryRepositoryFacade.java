package com.ridgue.homefood.database.repository.facade;

import com.ridgue.homefood.database.entity.CountryEntity;

import java.util.List;

public interface CountryRepositoryFacade {
    List<CountryEntity> findAll();
    CountryEntity findById(Long id);
    long create(CountryEntity countryEntity);
    void deleteById(Long id);
}
