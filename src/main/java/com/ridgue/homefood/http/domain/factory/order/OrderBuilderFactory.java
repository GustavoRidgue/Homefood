package com.ridgue.homefood.http.domain.factory.order;

import com.ridgue.homefood.http.domain.builder.OrderBuilder;
import com.ridgue.homefood.http.domain.builder.RestaurantBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class OrderBuilderFactory {
    private final OrderBuilder orderBuilder;
}
