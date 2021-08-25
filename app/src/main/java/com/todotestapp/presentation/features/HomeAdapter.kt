package com.todotestapp.presentation.features

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.todotestapp.databinding.ItemTaskBinding
import com.todotestapp.presentation.models.TaskUi

class HomeAdapter(val itemChecked: (TaskUi) -> Unit) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private var tasksList = mutableListOf<TaskUi>()

    fun submitList(list: List<TaskUi>) {
        tasksList.clear()
        tasksList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(tasksList[position])

    override fun getItemCount(): Int = tasksList.size

    inner class ViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: TaskUi) {
            binding.cbMark.isChecked = task.completed
            binding.tvTaskTitle.text = task.title
            binding.cbMark.setOnClickListener { itemChecked(task) }
        }
    }
}