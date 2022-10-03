package com.test.dagger2.example1.component;

import com.test.dagger2.example1.module.DogModule;
import com.test.dagger2.example1.ui.MainActivity1;

import javax.inject.Singleton;

import dagger.Component;
//快递员
@Singleton
@Component(modules = DogModule.class)
public interface MyComponent {

    //收获地址
    void injetMainActivity(MainActivity1 activity);
}
