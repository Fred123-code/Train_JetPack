package com.test.ioc_annation_lib.annation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)   //  在类上进行
@Retention(RetentionPolicy.RUNTIME)  //运行时
public @interface ContentView {
    int value() default -1;
}
