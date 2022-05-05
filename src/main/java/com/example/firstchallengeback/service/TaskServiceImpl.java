package com.example.firstchallengeback.service;

import com.example.firstchallengeback.dao.entity.Task;
import com.example.firstchallengeback.dao.repository.TaskRepository;
import com.example.firstchallengeback.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public TaskDTO saveTask(TaskDTO taskDTO) {
        Task task = toTask(taskDTO);
        Task saveTask = taskRepository.save(task);
        TaskDTO saveTaskDTO = toTaskDTO(saveTask);
        return saveTaskDTO;
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO) {
        Task task = toTask(taskDTO);
        Task saveTask = taskRepository.save(task);
        TaskDTO saveTaskDTO = toTaskDTO(saveTask);
        return saveTaskDTO;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    private TaskDTO toTaskDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setMessage(task.getMessage());
        taskDTO.setDone(task.getDone());
        taskDTO.setCategoryId(task.getCategoryId());
        return taskDTO;
    }

    private Task toTask(TaskDTO taskDTO) {
        Task task = new Task();
        if (taskDTO.getId() != null) {
            task.setId(taskDTO.getId());
        }
        task.setMessage(taskDTO.getMessage());
        task.setDone(taskDTO.getDone());
        task.setCategoryId(taskDTO.getCategoryId());
        return task;
    }

}
