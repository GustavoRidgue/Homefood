package com.ridgue.homefood.http.domain.factory;

import com.ridgue.homefood.http.domain.builder.CityBuilder;
import com.ridgue.homefood.http.domain.builder.ClientBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
public class CityBuilderFactory {
    private final CityBuilder cityBuilder;
}
