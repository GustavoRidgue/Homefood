package com.ridgue.homefood.domain;

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
    private boolean active;
}
