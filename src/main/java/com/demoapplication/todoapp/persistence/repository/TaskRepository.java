package com.demoapplication.todoapp.persistence.repository;

import com.demoapplication.todoapp.persistence.entity.Task;
import com.demoapplication.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> { //Nombre de la entidad y tipo de datos del identificador

    public List<Task> findAllByTaskStatus(TaskStatus status);

    @Modifying  //Esta anotacion sirve para indicar que es una Query de actualización
    @Query(value = "UPDATE TASK SET FINISHED=true WHERE ID=:id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
}
