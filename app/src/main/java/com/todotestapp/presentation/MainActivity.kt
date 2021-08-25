package com.todotestapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.todotestapp.data.repositories.TaskRepositoryImpl
import com.todotestapp.databinding.ActivityMainBinding
import com.todotestapp.domain.usecases.GetAllTasksUseCase
import com.todotestapp.domain.usecases.MarkTaskAsDoneSwitchUseCase

class MainActivity : AppCompatActivity() {
    private val adapter by lazy { TasksAdapter() }
    private val repository by lazy { TaskRepositoryImpl() }
    private val getTasksUseCase by lazy { GetAllTasksUseCase(repository) }
    private val markDoneUseCase by lazy { MarkTaskAsDoneSwitchUseCase(repository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tasks = getTasksUseCase.execute()
        binding.rvTasks.adapter = adapter
        adapter.submitList(tasks)
    }
}