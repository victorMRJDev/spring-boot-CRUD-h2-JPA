package com.example.appcrud.service;

import com.example.appcrud.exceptions.ToDoEsceptions;
import com.example.appcrud.mapper.TasknDTOToTask;
import com.example.appcrud.persistence.entity.Task;
import com.example.appcrud.persistence.entity.TaskStatus;
import com.example.appcrud.persistence.repository.TaskRepository;
import com.example.appcrud.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
//import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TasknDTOToTask mapper;

    public TaskService(TaskRepository repository, TasknDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = this.mapper.map(taskInDTO);

        return this.repository.save(task);
    }

    public List<Task> findAll() {
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskCompleted(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);

        if (!optionalTask.isPresent()) {
            throw new ToDoEsceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskFinished(id);
    }

    public void deletedById(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);

        if (!optionalTask.isPresent()) {
            throw new ToDoEsceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
}
