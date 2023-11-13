package com.malt.task

interface TaskMergeService {
    fun mergeTasks(taskToBeMergedIntoTheOtherOne: Task, taskToKeep: Task): Task
}

internal class DefaultTaskMergeService(
        private val taskRepository: TaskRepository,
) : TaskMergeService {

    override fun mergeTasks(taskToBeMergedIntoTheOtherOne: Task, taskToKeep: Task): Task {
        if (taskToBeMergedIntoTheOtherOne.id == taskToKeep.id) {
            throw TasksCanNotBeMergedException("Can't merge ${taskToBeMergedIntoTheOtherOne.id} into itself")
        }

        if (taskToBeMergedIntoTheOtherOne.ownerId != taskToKeep.ownerId) {
            throw TasksCanNotBeMergedException(
                    "${taskToBeMergedIntoTheOtherOne.id} and ${taskToKeep.id} have different owners")
        }

        val mergedTask = taskToKeep
                .withSummary("${taskToKeep.summary} - ${taskToBeMergedIntoTheOtherOne.summary}")
                .withDescription("""
                    ${taskToKeep.description}
                    
                    ${taskToBeMergedIntoTheOtherOne.description}
                """.trimIndent())

        taskRepository.save(mergedTask)
        taskRepository.delete(taskToBeMergedIntoTheOtherOne.id)

        return mergedTask
    }
}

class TaskMergeServiceFactory() {
    fun createTaskMergeService(taskRepository: TaskRepository): TaskMergeService {
        return DefaultTaskMergeService(taskRepository)
    }

}