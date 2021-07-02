package com.ridgue.homefood.database.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_payment_method")
@Data
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
}
