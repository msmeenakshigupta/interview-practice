package com.geekcircle.Java;

public @interface SmartPhone {

    String name() default "Nokia";

    int version() default 1;

}
