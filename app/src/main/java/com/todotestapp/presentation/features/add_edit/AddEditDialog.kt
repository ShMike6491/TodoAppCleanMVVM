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
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEditDialog : BottomSheetDialogFragment() {

    private val arguments: AddEditDialogArgs by navArgs()
    private val viewModel: AddEditViewModel by viewModels()

    private var _binding: BottomDialogAddEditBinding? = null
    private val binding get() = _binding!!

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
        _binding = BottomDialogAddEditBinding.bind(view)

        viewModel.init(arguments.task)

        viewModel.getText().observe(this, {
           if (it != null) binding.etTaskTitle.setText(it)
        })

        viewModel.onDismiss.observe(this, { dismiss() })

        binding.btnSubmit.setOnClickListener {
            viewModel.onSubmit(binding.etTaskTitle.text.toString())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}