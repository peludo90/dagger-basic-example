package com.example.dagger.ui

import androidx.lifecycle.ViewModel
import com.example.dagger.data.LocalDataSource
import com.example.dagger.data.TimeSession
import javax.inject.Inject

class MessageViewModel @Inject constructor(
    val dataSource: LocalDataSource,
    val timeSession: TimeSession
) : ViewModel()