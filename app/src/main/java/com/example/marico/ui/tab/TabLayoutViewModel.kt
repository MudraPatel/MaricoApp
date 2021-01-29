package com.example.marico.ui.tab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TabLayoutViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Tab Layout Fragment"
    }
    val text: LiveData<String> = _text
}