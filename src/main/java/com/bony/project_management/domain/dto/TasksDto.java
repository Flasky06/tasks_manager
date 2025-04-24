package com.bony.project_management.domain.dto;

import com.bony.project_management.domain.entities.TaskPriority;
import com.bony.project_management.domain.entities.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TasksDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus tasks
) {
}
