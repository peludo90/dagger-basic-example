package com.example.dagger

import android.app.Application
import com.example.dagger.di.AppComponent
import com.example.dagger.di.DaggerAppComponent

class LogApplication : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    private fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }
}

