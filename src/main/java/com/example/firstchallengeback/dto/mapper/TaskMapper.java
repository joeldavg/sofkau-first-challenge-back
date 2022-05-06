package com.example.firstchallengeback.dto.mapper;

import com.example.firstchallengeback.dao.entity.Task;
import com.example.firstchallengeback.dto.TaskDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDTO toTaskDTO(Task task);

    List<TaskDTO> toTasksDTO(List<Task> tasks);

    @InheritInverseConfiguration
    Task toTask(TaskDTO taskDTO);

    List<Task> toTasks(List<TaskDTO> tasksDTO);

}
