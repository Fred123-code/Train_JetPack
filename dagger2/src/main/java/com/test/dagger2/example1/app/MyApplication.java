package com.test.dagger2.example1.app;

import android.app.Application;

import com.test.dagger2.example1.component.DaggerMyComponent;
import com.test.dagger2.example1.component.MyComponent;
import com.test.dagger2.example1.module.DogModule;

public class MyApplication extends Application {

 private MyComponent myComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        myComponent = DaggerMyComponent.builder()
                .dogModule(new DogModule())
                .build();

    }

    public MyComponent getAppComponent() {
        return myComponent;
    }
}
