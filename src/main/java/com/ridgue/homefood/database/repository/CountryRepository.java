package com.ridgue.homefood.database.repository;

import com.ridgue.homefood.database.entity.CityEntity;
import com.ridgue.homefood.database.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Long> {
}
