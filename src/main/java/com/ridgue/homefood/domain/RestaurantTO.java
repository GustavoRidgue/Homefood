package com.ridgue.homefood.domain;

import com.ridgue.homefood.database.entity.PaymentMethod;
import com.ridgue.homefood.database.entity.embeeded.Address;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
//import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
public class RestaurantTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal shipping;
//    private Address address;
//    private LocalDate created;
//    private LocalDate lastUpdate;
//    private List<PaymentMethod> paymentMethods;
}
