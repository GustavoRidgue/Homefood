package com.ridgue.homefood.domain;

import com.ridgue.homefood.database.entity.*;
import com.ridgue.homefood.database.entity.embeeded.Address;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class OrderTO {
    private RestaurantEntity restaurant;
    private ProductEntity products;
    private BigDecimal price;
    private BigDecimal shipping;
    private Integer quantity;
    private BigDecimal totalPrice;
    private PaymentMethod paymentMethod;
    private Address deliveryAddress;
    private ClientEntity user;
    private OrderStatus status;
    private LocalDate creationDate;
    private LocalDate confirmationDate;
    private LocalDate deliveryDate;
    private LocalDate cancellationDate;
}
