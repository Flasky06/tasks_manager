package com.bony.project_management.mappers.impl;

import com.bony.project_management.domain.dto.TaskListDto;
import com.bony.project_management.domain.entities.Task;
import com.bony.project_management.domain.entities.TaskList;
import com.bony.project_management.domain.entities.TaskStatus;
import com.bony.project_management.mappers.TaskListMapper;
import com.bony.project_management.mappers.TaskMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskListMapperImpl implements TaskListMapper {

    private final TaskMapper taskMapper;

    public TaskListMapperImpl(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                Optional.ofNullable(taskListDto.tasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::fromDto)
                                .toList())
                        .orElse(null),
                null,
                null
        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size)
                        .orElse(0),
                Optional.ofNullable(taskList.getTasks())
                        .map(this::calculateTaskListProgress)
                        .orElse(0.0), // <<✅ 0.0 instead of null
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::toDto)
                                .toList())
                        .orElse(null)
        );
    }


    private Double calculateTaskListProgress(List<Task> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            return null;
        }
        long closedTaskCount = tasks.stream()
                .filter(task -> TaskStatus.CLOSED == task.getStatus())
                .count();

        return (double) closedTaskCount / tasks.size();
    }
}
