package com.example.firstchallengeback.service;

import com.example.firstchallengeback.entity.Task;

public interface TaskService {

    Task saveTask(Task task);

    Task updateTask(Task task);

    void deleteTask(Long id);

}
