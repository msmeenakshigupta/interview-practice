package com.geekcircle.Java.SystemDesign.RateLimiterMethodClass;

public class Driver {
    public static void main(String[] args) {
        LimiterService limiterService = LimiterService.getLimiterService();
        Object object = limiterService.call("Foo.a()");
        System.out.println(object);
    }
}
