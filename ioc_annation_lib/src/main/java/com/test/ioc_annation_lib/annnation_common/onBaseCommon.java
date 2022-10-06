package com.test.ioc_annation_lib.annnation_common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface onBaseCommon {
    //这里必须时通用代码
    /**
     * 事件三要素
     * setOnClickListener  setOnLongClickListener
     * View.OnClickListener()  View.OnLongClickListener()
     * onClick  onLongClick
     */
    String setCommonListener();
    Class setCommonObjectListener();
    String callMethod();
}
