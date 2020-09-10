package com.example.dagger.di

import android.content.Context
import com.example.dagger.ui.InteractionFragment
import com.example.dagger.ui.LogsFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DbModule::class, LocalStorageModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: InteractionFragment)
    fun inject(fragment: LogsFragment)
}