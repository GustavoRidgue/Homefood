package com.ridgue.homefood.domain;

import com.ridgue.homefood.database.entity.*;
import com.ridgue.homefood.database.entity.embeeded.Address;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrderTO {
    private Long id;
//    private RestaurantEntity restaurant;
//    private BigDecimal price;
    private ProductEntity products;
    private Integer quantity;
    private BigDecimal shipping;
    private BigDecimal totalPrice;
    private String paymentMethod;
    private String deliveryAddress; //
    private OrderStatus status;
    private LocalDate creationDate;
    private LocalDate confirmationDate;
    private LocalDate deliveryDate;
    private LocalDate cancellationDate;
    private String user;
}
