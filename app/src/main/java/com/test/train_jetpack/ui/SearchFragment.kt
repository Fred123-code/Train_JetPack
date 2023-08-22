package com.test.train_jetpack.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.train_jetpack.R
import com.test.train_jetpack.base.BaseFragment
import com.test.train_jetpack.databinding.FragmentSearchBinding
import com.test.train_jetpack.request.DownloadViewModel
import com.test.train_jetpack.viewmodel.SearchViewModel

/**
 * 搜索界面 的 Fragment
 */
class SearchFragment : BaseFragment(){

    private var mBinding: FragmentSearchBinding? = null
    private var mSearchViewModel: SearchViewModel? = null // 搜索界面 相关的 VM  // todo Status ViewModel
    private var mDownloadViewModel: DownloadViewModel? = null  // 下载相关的 VM // todo Request ViewModel 额外 1

    // private 点赞的ViewModle vm; // 额外 2

    // private 点赞的ViewModle vm; // 额外 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDownloadViewModel = getActivityViewModelProvider(mActivity!!).get(DownloadViewModel::class.java)
        mSearchViewModel = getFragmentViewModelProvider(this).get(SearchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_search, container, false)
        mBinding = FragmentSearchBinding.bind(view)
        mBinding ?.click = ClickProxy() // 设置监听
        mBinding ?.vm = mSearchViewModel // 设置 自身VM
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDownloadViewModel!!.downloadFileLiveData ?.observe(viewLifecycleOwner, { downloadFile ->

            // 修改了 StatusViewModel
            // 让我自身的VM 数据发送变化, 那么布局就会感应变化
            mSearchViewModel!!.progress.set(downloadFile.progress)
        })
    }

    inner class ClickProxy {

        private val PATH2 = "http://www.xiangxueketang.cn/"

        fun testNav() {
            val uri = Uri.parse(PATH2)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        fun back() {
            nav().navigateUp() // back键的时候，返回上一个界面
        }

        fun subscribe() {
            val uri = Uri.parse(PATH2)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        // 测试下载，离开页面即中止
        fun testLifecycleDownload() {
            mDownloadViewModel ?.requestDownloadFile()
        }

        // 测试下载，返回页面依然有效
        fun testDownload() {
            mDownloadViewModel ?.requestDownloadFile()
        }
    }
}