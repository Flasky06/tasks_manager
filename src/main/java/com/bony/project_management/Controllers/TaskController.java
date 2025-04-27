package com.bony.project_management.Controllers;

import com.bony.project_management.Services.TaskService;
import com.bony.project_management.domain.dto.TaskListDto;
import com.bony.project_management.domain.dto.TasksDto;
import com.bony.project_management.mappers.TaskMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public List<TasksDto> listTasks(){
        return taskService.listTasks()
                .stream()
                .map(taskMapper::toDto)
                .toList();
    };
}
