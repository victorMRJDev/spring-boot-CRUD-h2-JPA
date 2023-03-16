package com.example.appcrud.controller;

import com.example.appcrud.persistence.entity.Task;
import com.example.appcrud.persistence.entity.TaskStatus;
import com.example.appcrud.service.TaskService;
import com.example.appcrud.service.dto.TaskInDTO;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task crateTask(@RequestBody TaskInDTO taskInDTO) {
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll() {
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status") TaskStatus status) {
        return this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/mark_completed/{id}")
    public ResponseEntity<Void> markAsCompleted(@PathVariable("id") Long id) {
        this.taskService.updateTaskCompleted(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.taskService.deletedById(id);
        return ResponseEntity.noContent().build();
    }

}
