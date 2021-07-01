package com.ridgue.homefood.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ridgue.homefood.database.entity.embeeded.Address;
import lombok.Data;
//import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
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
