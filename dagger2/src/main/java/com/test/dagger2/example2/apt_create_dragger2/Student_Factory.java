package com.test.dagger2.example2.apt_create_dragger2;

import com.test.customs_dragger2.Factory;
import com.test.dagger2.example2.Student;
//@Inject student
public class Student_Factory implements Factory {
    @Override
    public Object get() {
        return null;
    }

    public static Student_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Student newInstance() {
        return new Student();
    }

    private static final class InstanceHolder {
        private static final Student_Factory INSTANCE = new Student_Factory();
    }
}
