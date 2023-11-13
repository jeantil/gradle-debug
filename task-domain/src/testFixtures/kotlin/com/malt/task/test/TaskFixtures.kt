package com.malt.task.test

import com.malt.task.*
import com.malt.task.DefaultTaskMergeService
import com.malt.test.time.SettableClock

open class TaskFixtures {

    val clock by lazy { SettableClock() }
    val taskRepository by lazy { InMemoryTaskRepository() }
    val taskMergeService: TaskMergeService by lazy { DefaultTaskMergeService(taskRepository) }

    fun givenAnExistingTask(
            id: TaskId = TaskId.generate(),
            ownerId: TaskOwnerId = TaskOwnerId("some-owner-id"),
            summary: String = "Some task summary",
            description: String? = "Some task description"
    ): Task {
        val task = TaskBuilder(
                id = id,
                ownerId = ownerId,
                summary = summary,
                description = description
        ).build()
        taskRepository.save(task)
        return task
    }
}
