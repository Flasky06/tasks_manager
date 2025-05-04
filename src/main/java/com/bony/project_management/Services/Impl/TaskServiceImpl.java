package com.bony.project_management.Services.Impl;

import com.bony.project_management.Repository.TaskRepository;
import com.bony.project_management.Services.TaskService;
import com.bony.project_management.domain.entities.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public List<Task> listTasks(UUID taskListId) {
        return taskRepository.findByTaskListId(taskListId);
    }
}
