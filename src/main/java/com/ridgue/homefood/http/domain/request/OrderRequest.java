package com.ridgue.homefood.http.domain.request;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.entity.KitchenEntity;
import com.ridgue.homefood.database.entity.PaymentMethod;
import com.ridgue.homefood.database.entity.ProductEntity;
import com.ridgue.homefood.database.entity.embeeded.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderRequest {
//    private Long id;
//    private RestaurantEntity restaurant;
    private ProductEntity product;
//    private BigDecimal price;
//    private BigDecimal shipping;
    private Integer quantity;
//    private BigDecimal totalPrice;
    private PaymentMethod paymentMethod;
    private Address deliveryAddress;
    private ClientEntity user;
//    private OrderStatus status;
//    private LocalDate creationDate;
//    private LocalDate confirmationDate;
//    private LocalDate deliveryDate;
//    private LocalDate cancellationDate;
}
