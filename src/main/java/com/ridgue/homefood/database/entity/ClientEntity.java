package com.ridgue.homefood.database.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private int age;
    @CreationTimestamp
    private LocalDate enterDate;
    @Column(nullable = false)
    private boolean active = false;
    @JsonIgnoreProperties
    @Column(nullable = false)
    private String password;
    @JsonIgnoreProperties
    private String token = "";
}


