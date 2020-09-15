package com.example.dagger.di

import android.app.Application
import com.example.dagger.LogApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, DbModule::class, LocalStorageModule::class, UiBuilderModule::class, ViewModelFactoryModule::class, GlobalViewModelModule::class])
interface AppComponent : AndroidInjector<LogApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}