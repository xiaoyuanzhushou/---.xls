package com.example.materialtest.ui.xuefenji

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class XuefenjiViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _text = MutableLiveData<String>().apply {
        value = "物理实验助手界面"
    }
    val text: LiveData<String> = _text
}
