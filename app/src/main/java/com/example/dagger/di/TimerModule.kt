package com.example.dagger.di

import com.example.dagger.data.TimeSession
import dagger.Module
import dagger.Provides

@Module
class TimerModule {

    @MessageScope
    @Provides
    fun providesTimerSession() = TimeSession()
}