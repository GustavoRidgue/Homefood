package com.ridgue.homefood.database.entity;

import com.ridgue.homefood.database.entity.embeeded.Address;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_order")
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private RestaurantEntity restaurant;

    @ManyToMany
    @JoinTable(name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> products = new ArrayList<>();

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private BigDecimal shipping;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(nullable = false)
    private PaymentMethod paymentMethod;

    @Embedded
    private Address deliveryAddress;

    @ManyToOne
    @JoinColumn(name = "user_client_id", nullable = false)
    private ClientEntity user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @CreationTimestamp
    private LocalDate creationDate;

    private LocalDate confirmationDate;

    private LocalDate deliveryDate;

    private LocalDate cancellationDate;
}
