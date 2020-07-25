package com.cybershark.myapplication.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cybershark.myapplication.util.Status

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _viewState = MutableLiveData<Status>().apply { value = Status.IDLE }
    val viewState: LiveData<Status> = _viewState
}