package com.example.firstchallengeback.service;

import com.example.firstchallengeback.dao.entity.Task;
import com.example.firstchallengeback.dao.repository.TaskRepository;
import com.example.firstchallengeback.dto.TaskDTO;
import com.example.firstchallengeback.dto.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapper mapper;

    @Override
    public TaskDTO saveTask(TaskDTO taskDTO) {
        Task task = mapper.toTask(taskDTO);
        Task saveTask = taskRepository.save(task);
        TaskDTO saveTaskDTO = mapper.toTaskDTO(saveTask);
        return saveTaskDTO;
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO) {
        Task task = mapper.toTask(taskDTO);
        Task saveTask = taskRepository.save(task);
        TaskDTO saveTaskDTO = mapper.toTaskDTO(saveTask);
        return saveTaskDTO;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}
