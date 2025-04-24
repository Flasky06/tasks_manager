package com.bony.project_management.mappers;

import com.bony.project_management.domain.dto.TasksDto;
import com.bony.project_management.domain.entities.Task;

public interface TaskMapper {
    Task fromDto(TasksDto tasksDto);

    TasksDto toDto(Task tasks);
}
