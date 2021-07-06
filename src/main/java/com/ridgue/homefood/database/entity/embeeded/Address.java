package com.ridgue.homefood.database.entity.embeeded;

import com.ridgue.homefood.database.entity.CityEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
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

    @ManyToOne
    @JoinColumn(name = "address_city_id")
    private CityEntity city;

    @Column(name = "publicPlace", nullable = false)
    private boolean publicPlace;
}
