package com.ridgue.homefood.database.entity.embeeded;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.ridgue.homefood.database.entity.CityEntity;
import com.ridgue.homefood.database.entity.StateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@JsonIgnoreType
//@AllArgsConstructor
//@NoArgsConstructor
@Embeddable
public class Address {
    private String cep;
    private String street;
    private int number;
    private String complement;
    private String district;
    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_city_id")
    private CityEntity city;
    private boolean publicPlace;
}
