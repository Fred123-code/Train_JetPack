package com.test.dagger2.example1.module;

import com.test.dagger2.example1.obj.Dog;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Type;

import javax.inject.Scope;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module //还是APT技术，ARoute
public class DogModule {
    @Singleton
    @Provides  //暴露出借口
    public Dog getDog(){
        return new Dog();
    }
}
