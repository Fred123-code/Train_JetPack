package com.test.ioc_annation_lib.annnation_common;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@onBaseCommon(setCommonListener = "setOnClickListener",
        setCommonObjectListener = View.OnClickListener.class,
        callMethod = "onClick")
public @interface onClickCommon {
    int value() default -1;
}
