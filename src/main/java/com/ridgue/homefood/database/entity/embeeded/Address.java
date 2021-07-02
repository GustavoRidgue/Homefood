package com.ridgue.homefood.database.entity.embeeded;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.ridgue.homefood.database.entity.CityEntity;
import com.ridgue.homefood.database.entity.StateEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@JsonIgnoreType
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "number", nullable = false)
    private int number;

    @Column(name = "complement", nullable = false)
    private String complement;

    @Column(name = "district", nullable = false)
    private String district;

//    @Column(nullable = false)
    @ManyToOne
    @JoinColumn(name = "address_city_id")
    private CityEntity city;

    @Column(name = "publicPlace", nullable = false)
    private boolean publicPlace;
}
