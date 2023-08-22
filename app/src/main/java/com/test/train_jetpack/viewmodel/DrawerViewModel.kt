package com.test.train_jetpack.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

/**
 * 左侧 Fragment 的 DrawerViewModel
 */
class DrawerViewModel : ViewModel() {
    // 记录单曲 页面状态
    val loadPage = ObservableField<String>()
}