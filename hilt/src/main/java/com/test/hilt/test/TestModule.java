package com.test.hilt.test;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class TestModule {
    @Binds
    public abstract TestInterface BindTestClass(TestImpl test);
}
