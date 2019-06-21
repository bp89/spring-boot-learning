package com.craigecomputing.dtos;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum Customer {
    RETAIL("retail"),
    FREELANCER("FreeLancer"),
    MARKET("market"),
    PUBLICATION("publication");

    Customer(String contentType) {
        this.contentType = contentType;
    }

    private String contentType;
    private static final Map<String, Customer> contentTypeMap;

    public String getContentType() {
        return this.contentType;
    }

    static {
        Map<String, Customer> map = new ConcurrentHashMap<String, Customer>();
        for (Customer type : Customer.values()) {
            map.put(type.getContentType(), type);
        }
        contentTypeMap = map;
    }

    public static Customer getContentType(String contentType) {
        return contentTypeMap.get(contentType);
    }

}
