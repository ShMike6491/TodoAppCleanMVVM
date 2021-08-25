package com.todotestapp.presentation.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.todotestapp.domain.usecases.GetAllTasksUseCase
import com.todotestapp.domain.usecases.MakeNewTaskUseCase
import com.todotestapp.domain.usecases.MarkTaskAsDoneSwitchUseCase
import com.todotestapp.presentation.mappers.asDomainModel
import com.todotestapp.presentation.mappers.asPresentationModel
import com.todotestapp.presentation.models.TaskUi

private const val UNKNOWN_VM_EXCEPTION = "Unknown view model class"

class HomeViewModel(
    private val getTasksUseCase: GetAllTasksUseCase,
    private val markDoneUseCase: MarkTaskAsDoneSwitchUseCase,
    private val makeNewUseCase: MakeNewTaskUseCase
) : ViewModel() {

    private val _taskData = MutableLiveData<List<TaskUi>>()
    val taskData: LiveData<List<TaskUi>> = _taskData

    fun onAttach() = update()

    fun newTaskCreated(task: TaskUi) {
        makeNewUseCase.execute(task.asDomainModel())
        update()
    }

    fun itemChecked(task: TaskUi) {
        markDoneUseCase.execute(task.id)
        update()
    }

    private fun update() {
        _taskData.value = getTasksUseCase.execute().asPresentationModel()
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

