package com.bony.project_management.Services.Impl;

import com.bony.project_management.Repository.TaskListRepository;
import com.bony.project_management.Services.TaskListService;
import com.bony.project_management.domain.entities.TaskList;
import org.springframework.stereotype.Service;

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
}
