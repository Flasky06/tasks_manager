package com.bony.project_management.Services;

import com.bony.project_management.domain.entities.Task;
import com.bony.project_management.domain.entities.TaskList;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<Task> listTasks(UUID taskListId);
}
