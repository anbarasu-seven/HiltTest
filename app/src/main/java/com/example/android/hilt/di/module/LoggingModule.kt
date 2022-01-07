package com.example.android.hilt.data

import com.example.android.hilt.logger.LoggerDataSource
import com.example.android.hilt.logger.LoggerDataSourceInMemoryImpl
import com.example.android.hilt.logger.LoggerDataSourceLocalImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
annotation class InMemoryLogger

@Qualifier
annotation class DatabaseLogger

@Module
@InstallIn(SingletonComponent::class)
abstract class LoggingDatabaseModule {

    @Binds
    @Singleton
    @DatabaseLogger
    abstract fun bindDatabaseLogger(impl: LoggerDataSourceLocalImpl): LoggerDataSource

}


@Module
@InstallIn(ActivityComponent::class)
abstract class LoggingInMemoryModule {

    @Binds
    @ActivityScoped
    @InMemoryLogger
    abstract fun bindInMemoryLogger(impl: LoggerDataSourceInMemoryImpl): LoggerDataSource

}
