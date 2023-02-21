package com.example.livedata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private val _counter: MutableLiveData<Int> = MutableLiveData();
    val counter: LiveData<Int> = _counter;

    fun generateRandomNumber() {
        val randomNumber = (Math.random() * 100).toInt()
        // setValue
        _counter.value = randomNumber;
        // postValue
        // _counter.postValue(randomNumber) ;
    }

    override fun onCleared() {
        super.onCleared()
    }
}