package com.ridgue.homefood.domain;

import lombok.Data;

@Data
public class ClientTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private int age;
//    private String password;
//    private Address address;
//    private boolean active;
//    private String token;
}
