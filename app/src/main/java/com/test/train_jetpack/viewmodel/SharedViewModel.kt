package com.test.train_jetpack.viewmodel

import androidx.lifecycle.ViewModel
import com.test.architecture.callback.UnPeekLiveData
import java.util.ArrayList

class SharedViewModel : ViewModel() {
    // 添加监听（可以弹上来的监听）
    // 是为了 sliding.addPanelSlideListener(new PlayerSlideListener(mBinding, sliding));
    val timeToAddSlideListener = UnPeekLiveData<Boolean>()

    // 可以控制 播放详情 点击/back 掉下来
    // 播放详情中 左手边滑动图标(点击的时候)，与 MainActivity back 是 会set(true)
    //  ----> 如果是扩大，也就是 详情页面展示了出来，就会被掉下来
    val closeSlidePanelIfExpanded = UnPeekLiveData<Boolean>()

    // 活动关闭的一些记录（播放条 缩小一条 与 扩大展开） 通知给 控制者的
    val activityCanBeClosedDirectly = UnPeekLiveData<Boolean>()

    // openMenu打开菜单的时候会 set触发---> 改变 openDrawer.setValue(aBoolean); 的值
    val openOrCloseDrawer = UnPeekLiveData<Boolean>()

    // 开启和关闭 卡片相关的状态，如果发生改变 会和 allowDrawerOpen 挂钩 (后续的扩展 用的字段)
    val enableSwipeDrawer = UnPeekLiveData<Boolean>()

    companion object {
        // 存放记录，打开过“搜索界面”就会记录下来，owner.getClass().getSimpleName():SearchFragment  (后续的扩展 用的字段)
        val TAG_OF_SECONDARY_PAGES: List<String> = ArrayList()
    }
}