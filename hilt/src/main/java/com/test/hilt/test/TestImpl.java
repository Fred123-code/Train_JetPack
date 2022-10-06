package com.test.hilt.test;

import android.util.Log;

import javax.inject.Inject;

public class TestImpl implements TestInterface{
    protected static final String TAG = "TestImpl";

    @Inject
    TestImpl(){

    }

    @Override
    public void method() {
        Log.d(TAG, "method: ");
    }
}
