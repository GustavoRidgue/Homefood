package com.ridgue.homefood.usecase.order;

import com.ridgue.homefood.database.entity.OrderEntity;
import com.ridgue.homefood.database.entity.OrderStatus;
import com.ridgue.homefood.database.entity.ProductEntity;
import com.ridgue.homefood.database.repository.facade.OrderRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.ProductRepositoryFacade;
import com.ridgue.homefood.database.repository.facade.RestaurantRepositoryFacade;
import com.ridgue.homefood.exceptions.InvalidFieldException;
import com.ridgue.homefood.exceptions.ResourceNotFoundException;
import com.ridgue.homefood.http.domain.request.OrderRequest;
import com.ridgue.homefood.http.domain.request.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class CreateOrderUseCase {
    private final OrderRepositoryFacade facade;
    private final RestaurantRepositoryFacade restaurantRepositoryFacade;

    public OrderEntity execute(OrderRequest request) {
        try {
            OrderEntity order = new OrderEntity();

            order.setRestaurant(restaurantRepositoryFacade.findById(request.getProduct().getRestaurant().getId()));

            order.setProduct(request.getProduct());

            order.setPrice(new BigDecimal("0"));
//            order.setPrice(request.getProduct().getPrice());

            order.setShipping(new BigDecimal("0"));
//            order.setShipping(request.getProduct().getRestaurant().getShipping());
//
//            System.out.println(request.getProduct());
//            System.out.println(request.getProduct().getRestaurant());
//            System.out.println(request.getProduct().getRestaurant().getShipping());

            order.setQuantity(request.getQuantity());

            order.setTotalPrice(new BigDecimal("0"));
//            order.setTotalPrice((
//                    request.getProduct().getPrice()
//                    .add(request.getProduct().getRestaurant().getShipping()))
//                    .multiply(BigDecimal.valueOf(Double.valueOf(request.getQuantity()))));

            order.setPaymentMethod(request.getPaymentMethod());
            order.setDeliveryAddress(request.getDeliveryAddress());
            order.setUser(request.getUser());
            order.setStatus(OrderStatus.CREATED);

            facade.create(order);

            //
//            order.setRestaurant(request.getProduct().getRestaurant());

            //
            order.setPrice(request.getProduct().getPrice());

            //
            order.setShipping(request.getProduct().getRestaurant().getShipping());

            System.out.println(request.getProduct());
            System.out.println(request.getProduct().getRestaurant());
            System.out.println(request.getProduct().getRestaurant().getShipping());

            //
            order.setTotalPrice((
                    request.getProduct().getPrice()
                            .add(request.getProduct().getRestaurant().getShipping()))
                    .multiply(BigDecimal.valueOf(Double.valueOf(request.getQuantity()))));

            return order;
        } catch (ResourceNotFoundException e) {
            throw new InvalidFieldException();
        }
    }
}