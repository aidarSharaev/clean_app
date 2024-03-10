package ru.aidar.app_common.base

import android.util.Log
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    override fun onCleared() {
        Log.d("ViewModel", "viewModel.onCleared")
        super.onCleared()
    }
}
