package com.ridgue.homefood.domain;

import com.ridgue.homefood.database.entity.KitchenEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class RestaurantTO {
    private Long id;
    private String name;
    private KitchenEntity kitchen;
    private BigDecimal shipping;
//    private Address address;
//    private LocalDate created;
//    private LocalDate lastUpdate;
//    private List<PaymentMethod> paymentMethods;
}
