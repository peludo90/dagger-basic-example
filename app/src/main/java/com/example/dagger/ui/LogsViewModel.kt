package com.example.dagger.ui

import androidx.lifecycle.ViewModel
import com.example.dagger.data.LocalDataSource
import javax.inject.Inject

class LogsViewModel @Inject constructor(val dataSource: LocalDataSource) : ViewModel()