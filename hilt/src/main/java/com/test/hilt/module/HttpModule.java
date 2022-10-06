package com.test.hilt.module;

import com.test.hilt.obj.HttpObject;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ApplicationComponent;

@InstallIn(ActivityComponent.class)
@Module
public class HttpModule {
    @Provides
    public HttpObject getHttpObject() {
        return new HttpObject();
    }
}
