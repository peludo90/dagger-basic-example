package com.example.dagger.di

import androidx.lifecycle.ViewModel
import com.example.dagger.ui.InteractionViewModel
import com.example.dagger.ui.LogsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class GlobalViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(InteractionViewModel::class)
    internal abstract fun bindInteractionViewModel(viewModel: InteractionViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LogsViewModel::class)
    internal abstract fun bindLogsViewModel(viewModel: LogsViewModel): ViewModel
}