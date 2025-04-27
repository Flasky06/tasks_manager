package com.bony.project_management.Services;

import com.bony.project_management.domain.entities.TaskList;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskListService {
    List<TaskList> listTaskLists();

    TaskList createTaskList(TaskList taskList);

    Optional<TaskList> getTaskList (UUID Id);

    TaskList updateTaskList(UUID taskListId, TaskList taskList);

    void deleteTask(UUID taskListId);
}
