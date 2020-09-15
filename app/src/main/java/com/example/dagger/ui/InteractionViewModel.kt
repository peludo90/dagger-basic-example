package com.example.dagger.ui

import androidx.lifecycle.ViewModel
import com.example.dagger.data.LocalDataSource
import javax.inject.Inject

class InteractionViewModel @Inject constructor(val dataSource: LocalDataSource) : ViewModel()