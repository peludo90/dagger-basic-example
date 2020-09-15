package com.example.dagger.di

import com.example.dagger.data.TimeSession
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class TimerModule {

    @MessageScope
    @Provides
    @Named(MESSAGE_TIME_SESSION)
    fun providesTimerSession() = TimeSession()
}