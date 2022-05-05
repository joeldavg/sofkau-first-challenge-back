package com.example.firstchallengeback.service;

import com.example.firstchallengeback.dto.TaskDTO;

public interface TaskService {

    TaskDTO saveTask(TaskDTO taskDTO);

    TaskDTO updateTask(TaskDTO taskDTO);

    void deleteTask(Long id);

}
