package com.ridgue.homefood.domain;

import com.ridgue.homefood.database.entity.RestaurantEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductTO {
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean active;
    private RestaurantEntity restaurant;
}
