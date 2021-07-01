package com.ridgue.homefood.http.domain.request;

import com.ridgue.homefood.database.entity.embeeded.Address;
import lombok.Data;
//import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ClientRequest {
    private String name;
    private String email;
    private String phoneNumber;
    private int age;
    private String password;
    private Address address;
//    private boolean active;
//    private String token;
}
