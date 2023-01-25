package com.demoapplication.todoapp.controller;

import com.demoapplication.todoapp.persistence.entity.Task;
import com.demoapplication.todoapp.service.TaskService;
import com.demoapplication.todoapp.service.dto.TaskInDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
       return this.taskService.createTask(taskInDTO);
    }

}
