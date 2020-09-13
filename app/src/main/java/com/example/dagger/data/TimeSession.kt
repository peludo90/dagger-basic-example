package com.example.dagger.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

class TimeSession() {

    private val mutableLiveDataSeconds = MutableLiveData<Long>().apply {
        value = 0
    }
    private var seconds: Long = 0L
    private val timer = Timer().apply {
        scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                seconds++
                mutableLiveDataSeconds.postValue(seconds)


            }
        }, 0, 1000)
    }

    fun timeSinceCreation() = seconds

    fun liveDataSecondSinceCreation(): LiveData<Long> = mutableLiveDataSeconds
}