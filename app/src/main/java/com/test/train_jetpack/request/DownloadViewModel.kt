package com.test.train_jetpack.request

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.train_jetpack.bean.DownloadFile
import com.test.train_jetpack.repository.HttpRequestManager

/**
 * 模拟下载，真正的下载，也是如此
 */
class DownloadViewModel : ViewModel() {

    var downloadFileLiveData: MutableLiveData<DownloadFile>? = null
        get() {
            if (field == null) {
                field = MutableLiveData<DownloadFile>()
            }
            return field
        }
        private set

    var downloadFileCanBeStoppedLiveData: MutableLiveData<DownloadFile>? = null
        get() {
            if (field == null) {
                field = MutableLiveData<DownloadFile>()
            }
            return field
        }
        private set

    fun requestDownloadFile() = HttpRequestManager.instance.downloadFile(downloadFileLiveData)
}