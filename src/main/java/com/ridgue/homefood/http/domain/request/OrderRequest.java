package com.ridgue.homefood.http.domain.request;

import com.ridgue.homefood.database.entity.KitchenEntity;
import com.ridgue.homefood.database.entity.PaymentMethod;
import com.ridgue.homefood.database.entity.embeeded.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderRequest {
//    private Long id;
    private String name;
    private KitchenEntity kitchen;
    private BigDecimal shipping;
    private Address address;
    private List<PaymentMethod> paymentMethods;
}
