package com.ridgue.homefood.http.controller.base;

public class URLMapping {
    private URLMapping() {}

    public static final String ROOT_API_PATH = "/homefood";

    public static final String ROOT_API_WS_CLIENTS = "/clients";
    public static final String ROOT_API_WS_CLIENT_BY_ID = ROOT_API_WS_CLIENTS + "/{id}";

    public static final String ROOT_API_WS_CLIENT_SAVE = ROOT_API_WS_CLIENTS + "/save";

    public static final String ROOT_API_WS_CLIENT_UPDATE = ROOT_API_WS_CLIENTS + "/update/{id}";

    public static final String ROOT_API_WS_CLIENT_DELETE = ROOT_API_WS_CLIENTS + "/delete";
}
