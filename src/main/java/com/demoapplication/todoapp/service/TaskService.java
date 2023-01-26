package com.demoapplication.todoapp.service;

import com.demoapplication.todoapp.mapper.TaskInDTOToTask;
import com.demoapplication.todoapp.persistence.entity.Task;
import com.demoapplication.todoapp.persistence.entity.TaskStatus;
import com.demoapplication.todoapp.persistence.repository.TaskRepository;
import com.demoapplication.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);

    }

    public List<Task> findAll(){
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus taskStatus){
        return this.repository.findAllByTaskStatus(taskStatus);
    }

    @Transactional //Hay que emplear esta anotacion cuando se realiza un cambio de datos...
    public void updateTaskAsFinishedService(Long id){
        this.repository.markTaskAsFinished(id);
    }

}
