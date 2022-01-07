package com.example.android.hilt.di.module

import android.content.Context
import androidx.room.Room
import com.example.android.hilt.data.db.AppDatabase
import com.example.android.hilt.data.db.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase = Room.databaseBuilder(
        context, AppDatabase::class.java, "logging.db"
    ).build()

    @Provides
    fun provideLogDao(database: AppDatabase): LogDao = database.logDao()

}