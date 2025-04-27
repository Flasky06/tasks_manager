package com.bony.project_management.Services;

import com.bony.project_management.domain.entities.Task;
import com.bony.project_management.domain.entities.TaskList;

import java.util.List;

public interface TaskService {
    List<Task> listTasks();
}
