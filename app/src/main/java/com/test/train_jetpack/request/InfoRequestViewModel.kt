package com.test.train_jetpack.request

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.train_jetpack.bean.LibraryInfo
import com.test.train_jetpack.repository.HttpRequestManager

/**
 * 抽屉的 左侧半界面 要使用的 ViewModel
 */
class InfoRequestViewModel : ViewModel() {

    var libraryLiveData: MutableLiveData<List<LibraryInfo>>? = null
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field
        }
        private set

    fun requestLibraryInfo() {
        HttpRequestManager.instance.getLibraryInfo(libraryLiveData)
    }
}