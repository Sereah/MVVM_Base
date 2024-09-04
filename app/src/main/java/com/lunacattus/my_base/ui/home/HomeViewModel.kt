package com.lunacattus.my_base.ui.home

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lunacattus.my_base.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): BaseViewModel() {

    private val _demoLiveData = MutableLiveData<String>()
    var demoLiveData: LiveData<String> = _demoLiveData

    override fun onStart(owner: LifecycleOwner) {

    }

    override fun onStop(owner: LifecycleOwner) {

    }


}