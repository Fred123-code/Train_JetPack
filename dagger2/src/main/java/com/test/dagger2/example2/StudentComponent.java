package com.test.dagger2.example2;


import com.test.customs_dragger2.annation.Component;

@Component(modules = StudentModule.class)
public interface StudentComponent {

    //收获地址
    void injetMainActivity(MainActivity2 activity);
}
