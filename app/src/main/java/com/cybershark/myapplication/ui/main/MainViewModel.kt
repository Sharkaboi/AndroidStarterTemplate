package com.cybershark.myapplication.ui.main

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.cybershark.myapplication.data.repositories.MainRepository
import com.cybershark.myapplication.util.UIState

class MainViewModel
@ViewModelInject
constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    mainRepository: MainRepository
) : ViewModel() {

    private val _viewState = MutableLiveData<UIState>().apply { value = UIState.IDLE }
    val viewState: LiveData<UIState> = _viewState
}