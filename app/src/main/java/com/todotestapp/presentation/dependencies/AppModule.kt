package com.todotestapp.presentation.dependencies

import com.todotestapp.domain.repositories.ITaskRepository
import com.todotestapp.domain.usecases.GetAllTasksUseCase
import com.todotestapp.domain.usecases.MakeNewTaskUseCase
import com.todotestapp.domain.usecases.MarkTaskAsDoneSwitchUseCase
import com.todotestapp.domain.usecases.UpdateExistingTaskUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {
    @Provides
    fun provideGetAllTasksUseCase(repository: ITaskRepository): GetAllTasksUseCase =
        GetAllTasksUseCase(repository)

    @Provides
    fun provideMakeNewTaskUseCase(repository: ITaskRepository): MakeNewTaskUseCase =
        MakeNewTaskUseCase(repository)

    @Provides
    fun provideMarkTaskAsDoneSwitchUseCase(repository: ITaskRepository): MarkTaskAsDoneSwitchUseCase =
        MarkTaskAsDoneSwitchUseCase(repository)

    @Provides
    fun provideUpdateExistingTaskUseCase(repository: ITaskRepository): UpdateExistingTaskUseCase =
        UpdateExistingTaskUseCase(repository)
}