package com.bony.project_management.mappers.Impl;

import com.bony.project_management.domain.dto.TasksDto;
import com.bony.project_management.domain.entities.Task;
import com.bony.project_management.mappers.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public Task fromDto(TasksDto tasksDto) {
        return new Task(
                tasksDto.id(),
                tasksDto.title(),
                tasksDto.description(),
                tasksDto.dueDate(),
                tasksDto.tasks(),
                tasksDto.priority(),
                null,
                null,
                null);
    }

    @Override
    public TasksDto toDto(Task tasks) {
        return new TasksDto(
                tasks.getId(),
                tasks.getTitle(),
                tasks.getDescription(),
                tasks.getDueDate(),
                tasks.getPriority(),
                tasks.getStatus()
        );
    }
}
