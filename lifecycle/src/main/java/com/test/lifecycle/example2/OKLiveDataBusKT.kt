package com.test.lifecycle.example2

import androidx.lifecycle.MutableLiveData

//取消粘性
class OKLiveDataBusKT {
    //存放订阅者
    private val Bus : MutableMap<String,BusMutableliveData<Any>> by lazy { HashMap() }

    class BusMutableliveData<T> private constructor() : MutableLiveData<T>() {

    }



}