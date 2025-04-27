package com.bony.project_management.Services.Impl;

import com.bony.project_management.Repository.TaskListRepository;
import com.bony.project_management.Services.TaskListService;
import com.bony.project_management.domain.entities.TaskList;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Optional<TaskList> getTaskList(UUID Id) {
        return taskListRepository.findById(Id);
    }

    @Override
    public TaskList updateTaskList(UUID taskListId, TaskList taskList) {
        if (null == taskList.getId()){
            throw new IllegalArgumentException("Task list must have an ID");
        }
        if (!Objects.equals(taskList.getId(),taskListId)){
            throw new IllegalArgumentException("Attempting to change taskList Id, this is not permitted");
        }
        LocalDateTime now = LocalDateTime.now();
        TaskList existingTaskList =taskListRepository.findById(taskListId)
                .orElseThrow(()->new IllegalArgumentException("TaskList not found!"));

        existingTaskList.setTitle(taskList.getTitle());
        existingTaskList.setDescription(taskList.getDescription());
        existingTaskList.setUpdated(now);
        return taskListRepository.save(existingTaskList);
    }

    @Override
    public void deleteTask(UUID taskListId) {
        taskListRepository.deleteById(taskListId);
    }
}
