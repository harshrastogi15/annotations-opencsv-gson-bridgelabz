package com.bridgelabz.annotations;

import jdk.jfr.EventType;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface information {
    String author();
    String date();
    String comment();
}
