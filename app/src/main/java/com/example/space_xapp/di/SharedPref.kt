package com.example.space_xapp.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped

const val APP_SHARED_PREFERENCE = "spaceXAppSharedPref"

@Module
@InstallIn(ActivityComponent::class)
class SharedPref {

    @ActivityScoped
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(APP_SHARED_PREFERENCE, Context.MODE_PRIVATE)
    }

}