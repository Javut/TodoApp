package com.demoapplication.todoapp.controller;

import com.demoapplication.todoapp.persistence.entity.Task;
import com.demoapplication.todoapp.persistence.entity.TaskStatus;
import com.demoapplication.todoapp.service.TaskService;
import com.demoapplication.todoapp.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

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

    @GetMapping
    public List<Task> findAll(){
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus taskStatus){ //PathVariable permite leer una variable enviada en la url, en este caso seria status
        return this.taskService.findAllByTaskStatus(taskStatus);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id){
        this.taskService.updateTaskAsFinishedService(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdController(@PathVariable("id") Long id){
        this.taskService.deleteByIdService(id);
        return ResponseEntity.noContent().build();
    }

}
