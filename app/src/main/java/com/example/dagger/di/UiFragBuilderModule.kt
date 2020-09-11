package com.example.dagger.di

import com.example.dagger.ui.InteractionFragment
import com.example.dagger.ui.LogsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiFragBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeInteractionFragment(): InteractionFragment

    @ContributesAndroidInjector
    abstract fun contributeLogsFragment(): LogsFragment
}