package com.example.marico.ui.image

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CaptureImageViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Capture Image Fragment"
    }
    val text: LiveData<String> = _text
}