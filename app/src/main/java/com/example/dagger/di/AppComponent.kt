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
@Component(modules = [AndroidInjectionModule::class, DbModule::class, LocalStorageModule::class, UiBuilderModule::class])
interface AppComponent : AndroidInjector<LogApplication> {

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance application: Application): AppComponent
    }
}