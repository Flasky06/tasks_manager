package com.bony.project_management.mappers;

import com.bony.project_management.domain.dto.TaskListDto;
import com.bony.project_management.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
