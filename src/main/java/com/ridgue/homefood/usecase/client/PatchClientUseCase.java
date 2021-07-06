package com.ridgue.homefood.usecase.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.http.ws.util.ClientFields;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PatchClientUseCase {
    private final ClientRepositoryFacade clientRepositoryFacade;

    public ClientEntity execute(Long id, Map<ClientFields, Object> fields) {
        // Used to convert objects
        ObjectMapper objectMapper = new ObjectMapper();
        ClientEntity clientEntity = objectMapper.convertValue(fields, ClientEntity.class);

        // Get client to be updated
        ClientEntity clientById = clientRepositoryFacade.findById(id);

        // Foreach to set values
        fields.forEach((property, value) -> {
            // Find all the ClientEntity fields
            Field field = ReflectionUtils.findField(ClientEntity.class, String.valueOf(property));

            // All fields are private, so it makes them be accessible
            field.setAccessible(true);

            Object convertedValue = ReflectionUtils.getField(field, clientEntity);

            // Set the field "field" in the object "clientById", passing the value "value"
            ReflectionUtils.setField(field, clientById, convertedValue);
        });

        return clientById;
    }
}