package com.test.train_jetpack.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel


/**
 * SearchViewModel 是专门为 SearchFragment（搜索界面）服务的
 * 自身的VM
 */
class SearchViewModel : ViewModel() {

    /**
     * 抖动
     * 频繁开辟内存控件，内存碎片，引发 内存抖动，内存泄漏的问题
     */

    // 防止抖动，拖动条的确很频繁，所以要防止抖动
    @JvmField
    val progress = ObservableField<Int>()
}