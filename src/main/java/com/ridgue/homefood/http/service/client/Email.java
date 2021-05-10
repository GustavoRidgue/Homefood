package com.ridgue.homefood.http.service.client;

import com.ridgue.homefood.database.entity.Client;

public interface Email {
    void notify(Client client, String message);
}
