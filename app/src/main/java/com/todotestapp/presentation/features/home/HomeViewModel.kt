package com.todotestapp.presentation.features.home

import androidx.lifecycle.*
import com.todotestapp.domain.usecases.GetAllTasksUseCase
import com.todotestapp.domain.usecases.MarkTaskAsDoneSwitchUseCase
import com.todotestapp.presentation.mappers.asPresentationModel
import com.todotestapp.presentation.models.TaskUi
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getTasksUseCase: GetAllTasksUseCase,
    private val markDoneUseCase: MarkTaskAsDoneSwitchUseCase
) : ViewModel() {

    fun getTaskData(): LiveData<List<TaskUi>> {
        val presentationFlow = getTasksUseCase.execute().map{it.asPresentationModel()}
        return presentationFlow.asLiveData()
    }

    fun itemChecked(task: TaskUi) = viewModelScope.launch {
        markDoneUseCase.execute(task.id)
    }

    class Factory(
        private val getTasksUseCase: GetAllTasksUseCase,
        private val markDoneUseCase: MarkTaskAsDoneSwitchUseCase
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(getTasksUseCase, markDoneUseCase) as T
            }
            throw IllegalArgumentException(UNKNOWN_VM_EXCEPTION)
        }
    }
}

private const val UNKNOWN_VM_EXCEPTION = "Unknown view model class"


