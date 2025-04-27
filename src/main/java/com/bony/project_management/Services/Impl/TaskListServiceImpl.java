package com.bony.project_management.Services.Impl;

import com.bony.project_management.Repository.TaskListRepository;
import com.bony.project_management.Services.TaskListService;
import com.bony.project_management.domain.entities.TaskList;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {
    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository){
        this.taskListRepository=taskListRepository;
    }
    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        if (null!= taskList.getId()){
            throw new IllegalArgumentException("The list already has an Id !");
        }
        if (null == taskList.getTitle() || taskList.getTitle().isBlank()){
            throw new IllegalArgumentException("Task List Title must be added !");
        }

        LocalDateTime now = LocalDateTime.now();
        return  taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now

        ));
    }
}
