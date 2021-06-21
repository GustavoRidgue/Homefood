package com.ridgue.homefood.http.domain.builder;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.domain.ClientTO;
import com.ridgue.homefood.exceptions.InvalidClientFieldException;
import com.ridgue.homefood.http.domain.request.ClientRequest;
import org.springframework.stereotype.Component;

@Component
public class ClientBuilder {
    public ClientTO build(ClientEntity clientEntity) {
        if (clientEntity == null) return null;

        ClientTO to = new ClientTO();
        to.setId(clientEntity.getId());
        to.setName(clientEntity.getName());
        to.setEmail(clientEntity.getEmail());
        to.setPhoneNumber(clientEntity.getPhoneNumber());
        to.setAge(clientEntity.getAge());
        to.setActive(clientEntity.isActive());
        to.setPassword(clientEntity.getPassword());
//        to.setToken(clientEntity.getToken());

        return to;
    }

    public ClientEntity build(ClientRequest clientRequest) {
        if (clientRequest == null) return null;

        try {
            ClientEntity client = new ClientEntity();
            client.setName(clientRequest.getName());
            client.setEmail(clientRequest.getEmail());
            client.setPhoneNumber(clientRequest.getPhoneNumber());
            client.setAge(clientRequest.getAge());
            client.setPassword(clientRequest.getPassword());
//            client.setActive(false);
//            client.setToken("");

            return client;
        } catch (Exception e) {
            throw new InvalidClientFieldException();
        }
    }
}
