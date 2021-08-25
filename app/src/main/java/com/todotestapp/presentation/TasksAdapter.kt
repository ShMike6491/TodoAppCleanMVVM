package com.todotestapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.todotestapp.databinding.ItemTaskBinding
import com.todotestapp.domain.models.TaskModel //TODO: change to local model

class TasksAdapter : RecyclerView.Adapter<TasksAdapter.ViewHolder>() {
    private var tasksList = mutableListOf<TaskModel>()

    fun submitList(list: List<TaskModel>) {
        tasksList.clear()
        tasksList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(tasksList[position])

    override fun getItemCount(): Int = tasksList.size

    class ViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: TaskModel) {
            binding.cbMark.isChecked = task.completed
            binding.tvTaskTitle.text = task.title
        }
    }
}