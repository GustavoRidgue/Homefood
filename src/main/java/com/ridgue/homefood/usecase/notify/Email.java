package com.ridgue.homefood.usecase.notify;

import com.ridgue.homefood.database.entity.ClientEntity;

public interface Email {
    void notify(ClientEntity clientEntity, String message);
}
