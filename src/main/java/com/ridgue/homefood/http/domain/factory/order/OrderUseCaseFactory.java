package com.ridgue.homefood.http.domain.factory.order;

import com.ridgue.homefood.usecase.order.CreateOrderUseCase;
import com.ridgue.homefood.usecase.order.FindOrderByIdUseCase;
import com.ridgue.homefood.usecase.order.ListOrderUseCase;
import com.ridgue.homefood.usecase.product.CreateProductUseCase;
import com.ridgue.homefood.usecase.product.FindProductByIdUseCase;
import com.ridgue.homefood.usecase.product.ListProductUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class OrderUseCaseFactory {
    private final ListOrderUseCase listOrderUseCase;
    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final CreateOrderUseCase createOrderUseCase;
}