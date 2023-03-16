package com.example.appcrud.persistence.repository;

import com.example.appcrud.persistence.entity.Task;
import com.example.appcrud.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findAllByTaskStatus(TaskStatus status);

    @Modifying
    @Query(value = "UPDATE TASK SET COMPLETED=true WHERE ID=:id", nativeQuery = true)
    public void markTaskFinished(@Param("id") Long id);
}
