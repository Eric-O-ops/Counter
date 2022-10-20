package com.geektech.counter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    val data: MutableLiveData<Int> = MutableLiveData()

    var count: Int = 0

    fun plus(){
        count++
        data.value = count


    }
    fun minus(){
        count--
        data.value = count

    }
}