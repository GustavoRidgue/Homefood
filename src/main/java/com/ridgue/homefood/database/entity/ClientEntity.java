package com.ridgue.homefood.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ridgue.homefood.database.entity.embeeded.Address;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_client")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private int age;

    @JsonIgnoreProperties
    @Embedded
    private Address address;

    @Column(nullable = false)
    private String email;

    @JsonIgnoreProperties
    @Column(nullable = false)
    private String password;

    @JsonIgnoreProperties
    @CreationTimestamp
    private LocalDate enterDate;

    @JsonIgnoreProperties
    @Column(nullable = false)
    private boolean active = false;

    @JsonIgnoreProperties
    private String token;
}


