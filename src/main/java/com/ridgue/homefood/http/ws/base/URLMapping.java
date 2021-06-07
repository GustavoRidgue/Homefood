package com.ridgue.homefood.http.ws.base;

public class URLMapping {
    private URLMapping() {}

    public static final String ROOT_API_PATH = "/homefood";

    public static final String ROOT_API_WS_CLIENTS = "/clients";
    public static final String ROOT_API_WS_CLIENT_BY_ID = ROOT_API_WS_CLIENTS + "/{id}";
    public static final String ROOT_API_WS_CLIENT_SAVE = ROOT_API_WS_CLIENTS + "/save";
    public static final String ROOT_API_WS_CLIENT_UPDATE = ROOT_API_WS_CLIENTS + "/update/{id}";
    public static final String ROOT_API_WS_CLIENT_DELETE = ROOT_API_WS_CLIENTS + "/delete/{id}";
    public static final String ROOT_API_WS_CLIENT_GET_REGISTRATION_CODE = ROOT_API_WS_CLIENTS + "/registration-code/{id}";
    public static final String ROOT_API_WS_CLIENT_ACTIVATE = ROOT_API_WS_CLIENTS + "/activate/{id}";

    public static final String ROOT_API_WS_CITIES = "/city";
    public static final String ROOT_API_WS_CITY_BY_ID = ROOT_API_WS_CITIES + "/{id}";
    public static final String ROOT_API_WS_CITY_SAVE = ROOT_API_WS_CITIES + "/save";
    public static final String ROOT_API_WS_CITY_DELETE = ROOT_API_WS_CITIES + "/delete/{id}";

    public static final String ROOT_API_WS_STATES = "/state";
    public static final String ROOT_API_WS_STATE_BY_ID = ROOT_API_WS_STATES + "/{id}";
    public static final String ROOT_API_WS_STATE_SAVE = ROOT_API_WS_STATES + "/save";
    public static final String ROOT_API_WS_STATE_DELETE = ROOT_API_WS_STATES + "/delete/{id}";

    public static final String ROOT_API_WS_COUNTRIES = "/country";
    public static final String ROOT_API_WS_COUNTRY_BY_ID = ROOT_API_WS_COUNTRIES + "/{id}";
    public static final String ROOT_API_WS_COUNTRY_SAVE = ROOT_API_WS_COUNTRIES + "/save";
    public static final String ROOT_API_WS_COUNTRY_DELETE = ROOT_API_WS_COUNTRIES + "/delete/{id}";

}
