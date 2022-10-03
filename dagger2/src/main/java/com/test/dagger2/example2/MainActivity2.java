package com.test.dagger2.example2;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.test.customs_dragger2.annation.Inject;
import com.test.dagger2.R;
import com.test.dagger2.example2.apt_create_dragger2.DaggerStudentComponent;


public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = MainActivity2.class.getSimpleName();

    @Inject
    public Student student;

    @Inject
    public Student student2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_copy);

        DaggerStudentComponent.create().injetMainActivity(this);

        Log.d(TAG, "student1=" + student.hashCode());
        Log.d(TAG, "student2=" + student2.hashCode());

    }
}