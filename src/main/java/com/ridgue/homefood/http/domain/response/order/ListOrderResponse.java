package com.ridgue.homefood.http.domain.response.order;

import com.ridgue.homefood.domain.OrderTO;
import com.ridgue.homefood.domain.RestaurantTO;
import com.ridgue.homefood.http.domain.response.DefaultResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ListOrderResponse extends DefaultResponse {
    private List<OrderTO> orderTOS;
}