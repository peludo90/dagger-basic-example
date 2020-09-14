package com.example.dagger

import android.app.Application
import com.example.dagger.di.AppComponent
import com.example.dagger.di.DaggerAppComponent
import com.example.dagger.di.MessageComponent
import com.example.dagger.di.TimerModule

class LogApplication : Application() {

    val appComponent: AppComponent by lazy {
        initializeComponent()
    }
    private var messageComponent: MessageComponent? = null

    fun getMessageComponent(): MessageComponent {
        if (messageComponent == null) {
            messageComponent = appComponent.messageComponent(TimerModule())
        }
        return messageComponent!!
    }

    fun releaseMessageComponent() {
        messageComponent = null
    }

    private fun initializeComponent(): AppComponent {
        return DaggerAppComponent.factory().create(applicationContext)
    }
}

