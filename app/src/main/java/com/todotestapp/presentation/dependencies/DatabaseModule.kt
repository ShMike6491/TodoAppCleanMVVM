package com.todotestapp.presentation.dependencies

import android.content.Context
import com.todotestapp.data.persistence.TaskDataBase
import com.todotestapp.data.repositories.ILocalStorage
import com.todotestapp.data.repositories.TaskRepositoryImpl
import com.todotestapp.domain.repositories.ITaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): TaskDataBase =
        TaskDataBase.getDatabase(context)

    @Singleton
    @Provides
    fun provideLocalStorage(database: TaskDataBase): ILocalStorage =
        database.taskDao()

    @Provides
    fun provideRepository(storage: ILocalStorage): ITaskRepository =
        TaskRepositoryImpl(storage)
}