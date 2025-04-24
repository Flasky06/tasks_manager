package com.bony.project_management.domain.dto;

import java.util.List;
import java.util.UUID;

public record TaskListDto(
        UUID id,
        String title,
        String description,
        Integer count,
        double progress,
        List<TasksDto> tasks
        ) {
}
