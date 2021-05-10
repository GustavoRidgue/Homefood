package com.ridgue.homefood.database.entity;

import lombok.Data;

@Data
public class Client {
    private String name;
    private String email;
    private String phoneNumber;
    private int age;
    private boolean active = false;
}
