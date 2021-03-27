package com.ma.lesson21.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ma.lesson21.Constants

class DataViewModel /* Done 24 */: ViewModel() {
    private val text: MutableLiveData<String> = MutableLiveData()// Done 25

    // val immutableText: LiveData<String> = text // Done 25. Alternative

    // Done 25
    fun getText(): LiveData<String> {
        Log.d(TAG, "getText $this")
        return text
    }

    // Done 26
    fun setText(text: String) {
        Log.d(TAG, "setText $text ($this)")
        this.text.value = text
    }

    companion object {
        const val TAG = Constants.TAG + "_vm"
    }
}