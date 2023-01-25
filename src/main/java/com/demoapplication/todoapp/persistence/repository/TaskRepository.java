package com.demoapplication.todoapp.persistence.repository;

import com.demoapplication.todoapp.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> { //Nombre de la entidad y tipo de datos del identificador


}
