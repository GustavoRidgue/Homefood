package com.ridgue.homefood.http.domain.request;

import com.ridgue.homefood.database.entity.PaymentMethod;
import com.ridgue.homefood.database.entity.embeeded.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class RestaurantRequest {
    private Long id;
    private String name;
    private String description;
    private BigDecimal shipping;
    private Address address;
    private List<PaymentMethod> paymentMethods;
}
