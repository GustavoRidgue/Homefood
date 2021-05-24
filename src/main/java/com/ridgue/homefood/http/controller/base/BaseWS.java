package com.ridgue.homefood.http.controller.base;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseWS {
    private BaseWS(){}

    public static final String INTERNAL_MESSAGE_ERROR = "Internal Process Error. Check the data. This error had this transactionID ";

//    public static Autenticacao getPrincipal(){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return (Autenticacao) authentication.getPrincipal();
//    }
}
