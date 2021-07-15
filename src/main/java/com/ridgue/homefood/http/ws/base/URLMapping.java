package com.ridgue.homefood.http.ws.base;

public class URLMapping {
    private URLMapping() {
    }

    public static final String ROOT_API_PATH = "/homefood";

    public static final String ROOT_API_WS_CLIENTS = "/clients";
    public static final String ROOT_API_WS_CLIENT_BY_ID = ROOT_API_WS_CLIENTS + "/{id}";
    public static final String ROOT_API_WS_CLIENT_SAVE = ROOT_API_WS_CLIENTS + "/save";
    public static final String ROOT_API_WS_CLIENT_UPDATE = ROOT_API_WS_CLIENTS + "/update/{id}";
    public static final String ROOT_API_WS_CLIENT_DELETE = ROOT_API_WS_CLIENTS + "/delete/{id}";
    public static final String ROOT_API_WS_CLIENT_GET_REGISTRATION_CODE = ROOT_API_WS_CLIENTS + "/registration-code/{id}";
    public static final String ROOT_API_WS_CLIENT_ACTIVATE = ROOT_API_WS_CLIENTS + "/activate/{id}";

    public static final String ROOT_API_WS_RESTAURANT = "/restaurant";
    public static final String ROOT_API_WS_RESTAURANT_BY_ID = ROOT_API_WS_RESTAURANT + "/{id}";
    public static final String ROOT_API_WS_RESTAURANT_SAVE = ROOT_API_WS_RESTAURANT + "/save";
    public static final String ROOT_API_WS_RESTAURANT_UPDATE = ROOT_API_WS_RESTAURANT + "/update/{id}";
    public static final String ROOT_API_WS_RESTAURANT_DELETE = ROOT_API_WS_RESTAURANT + "/delete/{id}";

    public static final String ROOT_API_WS_PRODUCT = "/product";
    public static final String ROOT_API_WS_PRODUCT_BY_ID = ROOT_API_WS_PRODUCT + "/{id}";
    public static final String ROOT_API_WS_PRODUCT_SAVE = ROOT_API_WS_PRODUCT + "/save";
    public static final String ROOT_API_WS_PRODUCT_UPDATE = ROOT_API_WS_PRODUCT + "/update/{id}";
    public static final String ROOT_API_WS_PRODUCT_DELETE = ROOT_API_WS_PRODUCT + "/delete/{id}";

    public static final String ROOT_API_WS_ORDER = "/order";
    public static final String ROOT_API_WS_ORDER_BY_ID = ROOT_API_WS_ORDER + "/{id}";
    public static final String ROOT_API_WS_ORDER_SAVE = ROOT_API_WS_ORDER + "/save";
    public static final String ROOT_API_WS_ORDER_UPDATE = ROOT_API_WS_ORDER + "/update/{id}";
    public static final String ROOT_API_WS_ORDER_DELETE = ROOT_API_WS_ORDER + "/delete/{id}";
}