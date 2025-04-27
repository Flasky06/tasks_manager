package com.bony.project_management.Controllers;

import com.bony.project_management.Services.TaskListService;
import com.bony.project_management.domain.dto.TaskListDto;
import com.bony.project_management.domain.dto.TasksDto;
import com.bony.project_management.domain.entities.TaskList;
import com.bony.project_management.mappers.TaskListMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> listTaskList(){
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();

    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto){
       TaskList createdTaskList = taskListService.createTaskList(
                taskListMapper.fromDto(taskListDto)
        );

       return taskListMapper.toDto(createdTaskList);
    }
}
