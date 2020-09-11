package com.example.dagger.di

import com.example.dagger.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class UiBuilderModule {

    @ContributesAndroidInjector(modules = [UiFragBuilderModule::class])
    abstract fun contributeMainActivity(): MainActivity

}