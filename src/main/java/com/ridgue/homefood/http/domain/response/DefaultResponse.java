package com.ridgue.homefood.http.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DefaultResponse {
    protected String status = "SUCCESS";
    private List<String> messages = new ArrayList<>();

    public void setMessage(String message){
        messages = Collections.singletonList(message);
    }

    public void add(String message) {
        messages.add(message);
    }

    //corretora, securitizadora, financeira
}
