package com.todotestapp.presentation.features.add_edit

import androidx.lifecycle.*
import com.todotestapp.domain.usecases.MakeNewTaskUseCase
import com.todotestapp.domain.usecases.UpdateExistingTaskUseCase
import com.todotestapp.presentation.mappers.asDomainModel
import com.todotestapp.presentation.models.TaskUi
import kotlinx.coroutines.launch

class AddEditViewModel(
    private val model: TaskUi? = null,
    private val makeNewUseCase: MakeNewTaskUseCase,
    private val updateExistingUseCase: UpdateExistingTaskUseCase
    ) : ViewModel() {

    private val dismissScreen = MutableLiveData<Boolean>()
    val onDismiss: LiveData<Boolean> = dismissScreen

    private val textToDisplay = MutableLiveData<String?>()

    fun getText(): LiveData<String?> {
        if (model != null) textToDisplay.value = model.title
        return textToDisplay
    }

    fun onSubmit(text: String) = viewModelScope.launch {
        if (text.isBlank()) return@launch

        if (model != null) {
            val task = model.apply {title = text}
            updateExistingUseCase.execute(task.asDomainModel())
        } else {
            makeNewUseCase.execute(TaskUi(title = text).asDomainModel())
        }

        val dismissVal = dismissScreen.value ?: true
        dismissScreen.postValue(!dismissVal)
    }

    class Factory(
        private val model: TaskUi? = null,
        private val makeNewUseCase: MakeNewTaskUseCase,
        private val updateExistingUseCase: UpdateExistingTaskUseCase
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AddEditViewModel::class.java)) {
                return AddEditViewModel(model, makeNewUseCase, updateExistingUseCase) as T
            }
            throw IllegalArgumentException(UNKNOWN_VM_EXCEPTION)
        }
    }
}

private const val UNKNOWN_VM_EXCEPTION = "Unknown view model class"