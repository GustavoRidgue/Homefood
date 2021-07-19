package com.ridgue.homefood.http.domain.factory.product;

import com.ridgue.homefood.usecase.product.CreateProductUseCase;
import com.ridgue.homefood.usecase.product.FindProductByIdUseCase;
import com.ridgue.homefood.usecase.product.ListProductUseCase;
import com.ridgue.homefood.usecase.restaurant.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class ProductUseCaseFactory {
    private final ListProductUseCase listProductUseCase;
    private final FindProductByIdUseCase findProductByIdUseCase;
    private final CreateProductUseCase createProductUseCase;
}