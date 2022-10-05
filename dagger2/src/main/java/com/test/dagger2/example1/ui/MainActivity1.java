package com.test.dagger2.example1.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.test.dagger2.R;
import com.test.dagger2.example1.app.MyApplication;
import com.test.dagger2.example1.component.DaggerMyComponent;
import com.test.dagger2.example1.module.DogModule;
import com.test.dagger2.example1.obj.Dog;

import javax.inject.Inject;

public class MainActivity1 extends AppCompatActivity {
    private static final String TAG = MainActivity1.class.getSimpleName();

    @Inject
    Dog dog1;

    @Inject
    Dog dog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_copy);

        //one
        DaggerMyComponent.create().injetMainActivity(this);


        //two：使用注解处理器细节
        DaggerMyComponent.builder()
                .dogModule(new DogModule())
                .build()
                .injetMainActivity(this);

        //three:全局
        ((MyApplication)getApplication())
                .getAppComponent()
                .injetMainActivity(this);



        Log.d(TAG, "dog1=" + dog1.hashCode());
        Log.d(TAG, "dog2=" + dog2.hashCode());
    }
}