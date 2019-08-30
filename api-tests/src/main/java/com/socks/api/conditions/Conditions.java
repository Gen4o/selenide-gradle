package com.socks.api.conditions;

public class Conditions {
    public static StatusCodeCondition statusCode(int code){
        return new StatusCodeCondition(code);
    }
}
