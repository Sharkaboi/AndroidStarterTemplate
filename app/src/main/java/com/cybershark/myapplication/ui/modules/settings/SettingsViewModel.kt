package com.cybershark.myapplication.ui.modules.settings

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.cybershark.myapplication.data.repositories.MainRepository
import com.cybershark.myapplication.util.UIState

class SettingsViewModel
@ViewModelInject
constructor(
    @Assisted savedStateHandle: SavedStateHandle,
    context: Context,
    mainRepository: MainRepository
) : ViewModel() {

    private val _viewState = MutableLiveData<UIState>().apply { value = UIState.IDLE }
    val viewState: LiveData<UIState> = _viewState
}