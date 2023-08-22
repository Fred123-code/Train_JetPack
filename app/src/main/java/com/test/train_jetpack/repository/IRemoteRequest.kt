package com.test.train_jetpack.repository

import androidx.lifecycle.MutableLiveData
import com.test.train_jetpack.bean.DownloadFile
import com.test.train_jetpack.bean.LibraryInfo
import com.xiangxue.puremusic.data.bean.TestAlbum

/**
 * 远程请求标准接口（在仓库里面）
 * 只为 HttpRequestManager 服务
 */
interface IRemoteRequest {

    fun getFreeMusic(liveData: MutableLiveData<TestAlbum>?)

    fun getLibraryInfo(liveData: MutableLiveData<List<LibraryInfo>>?)

    // 下载文件
    fun downloadFile(liveData: MutableLiveData<DownloadFile>?)
}