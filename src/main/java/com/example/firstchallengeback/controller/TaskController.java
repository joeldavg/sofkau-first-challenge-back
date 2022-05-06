package com.example.firstchallengeback.controller;

import com.example.firstchallengeback.dto.TaskDTO;
import com.example.firstchallengeback.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/todo/task")
@CrossOrigin(origins = "http://localhost:3000/")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("save")
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO) {
        return taskService.saveTask(taskDTO);
    }

    @PutMapping("update")
    public TaskDTO updateTask(@RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(taskDTO);
    }

    @DeleteMapping("delete/{id}")
    public void deleteTask(@PathVariable("id") Long id) {
        taskService.deleteTask(id);
    }

}
