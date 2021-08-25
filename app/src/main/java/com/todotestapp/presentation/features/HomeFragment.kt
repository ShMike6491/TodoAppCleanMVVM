package com.todotestapp.presentation.features

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.todotestapp.R
import com.todotestapp.data.repositories.TaskRepositoryImpl
import com.todotestapp.databinding.FragmentHomeBinding
import com.todotestapp.domain.usecases.GetAllTasksUseCase
import com.todotestapp.domain.usecases.MakeNewTaskUseCase
import com.todotestapp.domain.usecases.MarkTaskAsDoneSwitchUseCase
import com.todotestapp.presentation.TodoApp
import com.todotestapp.presentation.models.TaskUi

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var binding: FragmentHomeBinding? = null
    private val b get() = binding!!

    private val adapter = HomeAdapter { clickCallback(it) }
    private val viewModel: HomeViewModel by viewModels {
        val database = ((requireActivity().application) as TodoApp).database
        val repository = TaskRepositoryImpl(database.taskDao())
        HomeViewModel.Factory(
            GetAllTasksUseCase(repository),
            MarkTaskAsDoneSwitchUseCase(repository),
            MakeNewTaskUseCase(repository)
        )
    }

    private val clickCallback = { task: TaskUi ->
        viewModel.itemChecked(task)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        b.rvTasks.adapter = adapter
        viewModel.onAttach()
        viewModel.taskData.observe(viewLifecycleOwner, { adapter.submitList(it) })

        b.fabAddNew.setOnClickListener {
            viewModel.newTaskCreated(TaskUi(6, "test", false))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}