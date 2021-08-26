package com.todotestapp.presentation.features.add_edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.todotestapp.R
import com.todotestapp.databinding.BottomDialogAddEditBinding
import com.todotestapp.presentation.TodoApp
import com.todotestapp.presentation.models.TaskUi

class AddEditDialog : BottomSheetDialogFragment() {

    private val arguments: AddEditDialogArgs by navArgs()
    private val viewModel: AddEditViewModel by viewModels {
        val dependencies = (requireActivity().application) as TodoApp
        val passedData: TaskUi? = arguments.task
        AddEditViewModel.Factory(
            passedData,
            dependencies.makeNewTaskUseCae,
            dependencies.updateExistingUseCase
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(
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
}