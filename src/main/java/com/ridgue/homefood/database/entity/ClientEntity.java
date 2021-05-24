package com.ridgue.homefood.database.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_client")
@Data
public class ClientEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private int age;
    private boolean active = false;
}


