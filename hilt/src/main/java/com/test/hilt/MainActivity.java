package com.test.hilt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.test.hilt.obj.HttpObject;
import com.test.hilt.test.TestInterface;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Hilt_Main";
    @Inject
    HttpObject object1;

    @Inject
    HttpObject object2;

    @Inject
    TestInterface testInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "object1=" + object1.hashCode());
        Log.d(TAG, "object2=" + object2.hashCode());

        testInterface.method();
    }
}