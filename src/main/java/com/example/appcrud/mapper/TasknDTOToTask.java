package com.example.appcrud.mapper;

import com.example.appcrud.persistence.entity.Task;
import com.example.appcrud.persistence.entity.TaskStatus;
import com.example.appcrud.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TasknDTOToTask implements IMapper<TaskInDTO, Task> {
    @Override
    public Task map(TaskInDTO input) {

        Task task = new Task();

        task.setTitle(input.getTitle());
        task.setDescription(input.getDescription());
        task.setEta(input.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setCompleted(false);
        task.setTaskStatus(TaskStatus.ON_TIME);

        return task;
    }
}
