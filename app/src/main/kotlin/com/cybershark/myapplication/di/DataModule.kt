package com.cybershark.myapplication.di

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import com.cybershark.myapplication.data.repositories.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        @ApplicationContext context: Context
    ): MainRepository = MainRepository(context)

    @Singleton
    @Provides
    fun getSharedPrefs(@ApplicationContext context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
}