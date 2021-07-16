package com.ridgue.homefood.http.domain.builder;

import com.ridgue.homefood.database.entity.OrderEntity;
import com.ridgue.homefood.database.entity.OrderStatus;
import com.ridgue.homefood.database.entity.ProductEntity;
import com.ridgue.homefood.database.entity.RestaurantEntity;
import com.ridgue.homefood.domain.OrderTO;
import com.ridgue.homefood.domain.RestaurantTO;
import com.ridgue.homefood.http.domain.request.RestaurantRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderBuilder {
    public OrderTO build(OrderEntity order) {
        if (order == null) return null;

        OrderTO to = new OrderTO();

        List<String> names = new ArrayList<>();

        for (ProductEntity prod : order.getProducts()) {
            names.add(prod.getName());
        }

        to.setProducts(names);

        to.setId(order.getId());
        to.setTotalPrice(order.getTotalPrice());
        to.setShipping(order.getShipping());
        to.setQuantity(order.getQuantity());
        to.setPaymentMethod(order.getPaymentMethod().getName());
        to.setUser(order.getUser().getName());
        to.setStatus(OrderStatus.CREATED);
        to.setCreationDate(order.getCreationDate());
        to.setConfirmationDate(order.getConfirmationDate());
        to.setDeliveryDate(order.getDeliveryDate());
        to.setCancellationDate(order.getCancellationDate());
        to.setDeliveryAddress(
                order.getDeliveryAddress().getStreet() +
                ", number " + order.getDeliveryAddress().getNumber() +
                " - " + order.getDeliveryAddress().getComplement() +
                ", " + order.getDeliveryAddress().getCity().getName());

        return to;
    }

//    public RestaurantEntity build(RestaurantRequest restaurantRequest) {
//        if (restaurantRequest == null) return null;
//
//        RestaurantEntity restaurant = new RestaurantEntity();
//        restaurant.setName(restaurantRequest.getName());
//
//        return restaurant;
//    }
}
