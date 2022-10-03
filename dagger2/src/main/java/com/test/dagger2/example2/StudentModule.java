package com.test.dagger2.example2;

import com.test.customs_dragger2.annation.Module;
import com.test.customs_dragger2.annation.Provides;

@Module
public class StudentModule {

    @Provides  //暴露出借口
    public Student getStudent(){
        return new Student();
    }
}
