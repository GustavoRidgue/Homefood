package com.ridgue.homefood.database.repository;

import com.ridgue.homefood.database.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
