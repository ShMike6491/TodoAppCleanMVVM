package com.todotestapp.presentation.features.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.todotestapp.R
import com.todotestapp.databinding.FragmentHomeBinding
import com.todotestapp.presentation.TodoApp
import com.todotestapp.presentation.models.TaskUi

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var binding: FragmentHomeBinding? = null
    private val b get() = binding!!

    private val adapter = HomeAdapter ({ clickCallback(it) }, { navCallback(it) })
    private val viewModel: HomeViewModel by viewModels {
        val dependencies = (requireActivity().application) as TodoApp
        HomeViewModel.Factory(
            dependencies.getAllTasksUseCase,
            dependencies.markSwitchUseCase
        )
    }

    private val clickCallback = { task: TaskUi ->
        viewModel.itemChecked(task)
    }

    private val navCallback = { task: TaskUi ->
        val action = HomeFragmentDirections.actionHomeFragmentToAddEditDialog( task )
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        b.rvTasks.adapter = adapter
        viewModel.getTaskData().observe(viewLifecycleOwner, { adapter.submitList(it) })

        b.fabAddNew.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToAddEditDialog()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}