package com.todotestapp.presentation.features

import androidx.lifecycle.*
import com.todotestapp.domain.usecases.GetAllTasksUseCase
import com.todotestapp.domain.usecases.MakeNewTaskUseCase
import com.todotestapp.domain.usecases.MarkTaskAsDoneSwitchUseCase
import com.todotestapp.presentation.mappers.asDomainModel
import com.todotestapp.presentation.mappers.asPresentationModel
import com.todotestapp.presentation.models.TaskUi
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getTasksUseCase: GetAllTasksUseCase,
    private val markDoneUseCase: MarkTaskAsDoneSwitchUseCase,
    private val makeNewUseCase: MakeNewTaskUseCase
) : ViewModel() {

    fun getTaskData(): LiveData<List<TaskUi>> {
        val presentationFlow = getTasksUseCase.execute().map{it.asPresentationModel()}
        return presentationFlow.asLiveData()
    }

    fun newTaskCreated(task: TaskUi) = viewModelScope.launch {
        makeNewUseCase.execute(task.asDomainModel())
    }

    fun itemChecked(task: TaskUi) = viewModelScope.launch {
        markDoneUseCase.execute(task.id)
    }

    class Factory(
        private val getTasksUseCase: GetAllTasksUseCase,
        private val markDoneUseCase: MarkTaskAsDoneSwitchUseCase,
        private val makeNewUseCase: MakeNewTaskUseCase
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(getTasksUseCase, markDoneUseCase, makeNewUseCase) as T
            }
            throw IllegalArgumentException(UNKNOWN_VM_EXCEPTION)
        }
    }
}

private const val UNKNOWN_VM_EXCEPTION = "Unknown view model class"


