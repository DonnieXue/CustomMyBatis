package com.donnie.annotation;

import java.lang.annotation.*;

/**
 * Created by BRL on 2018/6/1.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyInsert {
    String values();
}
