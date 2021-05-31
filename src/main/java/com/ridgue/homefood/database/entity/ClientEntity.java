package com.ridgue.homefood.database.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_client")
@Data
public class ClientEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private boolean active = false;
}


