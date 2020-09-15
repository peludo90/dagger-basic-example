package com.example.dagger.di

import androidx.lifecycle.ViewModel
import com.example.dagger.ui.InteractionViewModel
import com.example.dagger.ui.LogsViewModel
import com.example.dagger.ui.MessageViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MessageViewModel::class)
    internal abstract fun bindMessageViewModel(viewModel: MessageViewModel): ViewModel
}