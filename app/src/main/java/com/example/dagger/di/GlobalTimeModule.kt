package com.example.dagger.di

import com.example.dagger.data.TimeSession
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class GlobalTimeModule {

    @Singleton
    @Provides
    @Named(APP_TIME_SESSION)
    fun providesTimerSession() = TimeSession()
}