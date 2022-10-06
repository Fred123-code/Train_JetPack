package com.test.ioc_annation_lib;

import android.util.Log;
import android.view.View;

import com.test.ioc_annation_lib.annation.BindView;
import com.test.ioc_annation_lib.annation.ContentView;
import com.test.ioc_annation_lib.annation.click;
import com.test.ioc_annation_lib.annnation_common.onBaseCommon;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InjectTool {
    public static final String TAG = InjectTool.class.getSimpleName();


    public static void inject(Object object) {
        injectSetContentView(object);

        injectBindView(object);

        injectClick(object);

        //>>>>>>>>>>>>>>>>>>>>>>>下面时兼容版本
        injectEvent(object);

    }

    private static void injectEvent(Object object) {
        Class<?> mMainActivityClass = object.getClass();

        Method[] declaredMethods = mMainActivityClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);

            Annotation[] annotations = declaredMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                //获取当前注解的父注解 是否有 onBaseCommon注解
                Class<? extends Annotation> annotationType = annotation.annotationType();
                onBaseCommon annotationTypeAnnotation = annotationType.getAnnotation(onBaseCommon.class);

                if (annotationTypeAnnotation == null){
                    continue;
                }

                String setCommonListener = annotationTypeAnnotation.setCommonListener();
                Class setCommonObjectListener = annotationTypeAnnotation.setCommonObjectListener();
                String callMethod = annotationTypeAnnotation.callMethod();


                try{
                    Method valueIdMethod = annotationType.getDeclaredMethod("value");
                    valueIdMethod.setAccessible(true);
                    int valueId = (int) valueIdMethod.invoke(annotation);

                    Method findViewById = mMainActivityClass.getMethod("findViewById", int.class);
                    Object resultView = findViewById.invoke(object,valueId);

                    Method ViewMethod = resultView.getClass().getDeclaredMethod(setCommonListener, setCommonObjectListener);
                    //动态代理 监听第三个
                    Object proxyInstance = Proxy.newProxyInstance(
                            setCommonListener.getClass().getClassLoader(), //动态代理内部需要的ClassLoader
                            new Class[]{setCommonObjectListener},
                            new InvocationHandler() {
                                @Override
                                public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                                    return declaredMethod.invoke(o, null);
                                }
                            }
                    );
                    //第三个事件
                    ViewMethod.invoke(resultView,proxyInstance);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

    private static void injectClick(Object object) {
        Class<?> mMainActivityClass = object.getClass();

        Method[] declaredMethods = mMainActivityClass.getDeclaredMethods();

        for (Method method : declaredMethods) {
            method.setAccessible(true);
            click clickAnnotation = method.getAnnotation(click.class);
            if (clickAnnotation == null){
                continue;
            }
            int valueId = clickAnnotation.value();

            try {
                Method findViewById = mMainActivityClass.getMethod("findViewById", int.class);
                Object resultView = findViewById.invoke(object,valueId);

                //赋值给到
                View view1 = (View) resultView;
                view1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            method.invoke(object);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                });

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }

    private static void injectBindView(Object object) {
        Class<?> mMainActivityClass = object.getClass();

        Field[] declaredFields = mMainActivityClass.getDeclaredFields();

        for (Field field : declaredFields) {
            field.setAccessible(true);  //让JVM不用管private
            //只关心BindView注解
            BindView bindView = field.getAnnotation(BindView.class);
            if (bindView == null) {
                continue;
            }
            int valueId = bindView.value();
            try {
                Method findViewById = mMainActivityClass.getMethod("findViewById", int.class);
                Object resultView = findViewById.invoke(object,valueId);

                //赋值给到
                field.set(object,resultView);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
    }


    private static void injectSetContentView(Object object) {
        Class<?> mMainActivityClass = object.getClass();

        //获取 ContentView注解
        ContentView mContentViewAnnotation = mMainActivityClass.getAnnotation(ContentView.class);

        if (mContentViewAnnotation == null) {
            Log.d(TAG, "mContentViewAnnotation is null");
            return;
        }

        //获取layoutid
        int layoutid = mContentViewAnnotation.value();

        //setContentView(R.layout.activity_main);
        try {
            Method setContentViewMethod = mMainActivityClass.getMethod("setContentView", int.class);
            setContentViewMethod.invoke(object,layoutid);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
