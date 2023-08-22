package com.test.train_jetpack

import android.app.Activity
import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.test.architecture.utils.Utils
import com.test.train_jetpack.player.PlayerManager

class MyApplication : Application(), ViewModelStoreOwner {
    private var mAppViewModelStore: ViewModelStore? = null
    private var mFactory: ViewModelProvider.Factory? = null
    override fun onCreate() {
        super.onCreate()
        Utils.init(this)
        mAppViewModelStore = ViewModelStore()
        // 这里必须初始化一下，是为了保证播放音乐管理类（PlayerManager.java） 不会为null，从而不引发空指针异常
        PlayerManager.instance.init(this)
    }

    // 专门给 BaseActivity 与 BaseFragment 用的
    fun getAppViewModelProvider(activity: Activity): ViewModelProvider {
        return ViewModelProvider(
            (activity.applicationContext as MyApplication),
            (activity.applicationContext as MyApplication).getAppFactory(activity) !!
        )
    }

    // AndroidViewModelFactory 工程是为了创建ViewModel，给上面的getAppViewModelProvider函数用的
    private fun getAppFactory(activity: Activity): ViewModelProvider.Factory? {
        val application = checkApplication(activity)
        if (mFactory == null) {
            mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        }
        return mFactory
    }

    // 监测下 Activity是否为null
    private fun checkApplication(activity: Activity): Application {
        return activity.application
            ?: throw IllegalStateException(
                "Your activity/fragment is not yet attached to "
                        + "Application. You can't request ViewModel before onCreate call."
            )
    }

    // TODO 暴露出去 给外界用
    // 此函数只给 NavHostFragment 使用
    override fun getViewModelStore(): ViewModelStore = mAppViewModelStore !!
}