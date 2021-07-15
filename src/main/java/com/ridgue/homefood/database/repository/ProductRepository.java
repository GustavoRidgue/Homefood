package com.ridgue.homefood.database.repository;

import com.ridgue.homefood.database.entity.ProductEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
