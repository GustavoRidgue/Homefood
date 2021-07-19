package com.ridgue.homefood.http.domain.request;

import com.ridgue.homefood.database.entity.RestaurantEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private RestaurantEntity restaurant;
}
