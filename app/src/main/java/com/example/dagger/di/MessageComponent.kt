package com.example.dagger.di

import com.example.dagger.ui.MessageFragment
import dagger.Subcomponent

@MessageScope
@Subcomponent(modules = [TimerModule::class])
interface MessageComponent {

    fun inject(fragment: MessageFragment)
}