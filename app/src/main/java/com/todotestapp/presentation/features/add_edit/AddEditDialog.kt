package com.todotestapp.presentation.features.add_edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.todotestapp.R
import com.todotestapp.data.repositories.TaskRepositoryImpl
import com.todotestapp.databinding.BottomDialogAddEditBinding
import com.todotestapp.domain.usecases.MakeNewTaskUseCase
import com.todotestapp.domain.usecases.UpdateExistingTaskUseCase
import com.todotestapp.presentation.TodoApp
import com.todotestapp.presentation.models.TaskUi

class AddEditDialog : BottomSheetDialogFragment() {

    private val viewModel: AddEditViewModel by viewModels {
        val database = ((requireActivity().application) as TodoApp).database
        val repository = TaskRepositoryImpl(database.taskDao())
        val passedData: TaskUi? = arguments?.getParcelable(DETAILS_TAG)
        AddEditViewModel.Factory(
            passedData,
            MakeNewTaskUseCase(repository),
            UpdateExistingTaskUseCase(repository)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = inflater.inflate(
        R.layout.bottom_dialog_add_edit,
        container,
        false
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = BottomDialogAddEditBinding.bind(view)

        viewModel.getText().observe(this, {
           if (it != null) binding.etTaskTitle.setText(it)
        })

        viewModel.onDismiss.observe(this, { dismiss() })

        binding.btnSubmit.setOnClickListener {
            viewModel.onSubmit(binding.etTaskTitle.text.toString())
        }
    }

    companion object {
        private const val DETAILS_TAG = "com.todotestapp.presentation.features.add_edit.details"

        fun newInstance(data: TaskUi? = null): AddEditDialog {
            val args = Bundle()
            args.putParcelable(DETAILS_TAG, data)
            return AddEditDialog().apply { arguments = args }
        }
    }
}