package com.todotestapp.data.persistence

import com.todotestapp.domain.models.TaskModel
import java.util.*

class TempTaskStore {
    private var tempDB: MutableMap<Int, TaskModel> = mutableMapOf(
        1 to TaskModel(1, "Buy Grocery", false),
        2 to TaskModel(2, "Send Email", false),
        3 to TaskModel(3, "Finish assignment", false),
        4 to TaskModel(4, "Done task", true),
        5 to TaskModel(5, "Play video games", false)
    )

    fun getAllTasks(): List<TaskModel> = LinkedList(tempDB.values)
    fun findTaskById(id: Int): TaskModel? = tempDB[id]
    fun deleteAll() = tempDB.clear()
    fun deleteById(id: Int) = tempDB.remove(id)
    fun insertTask(task: TaskModel) = tempDB.put(task.id, task)
}