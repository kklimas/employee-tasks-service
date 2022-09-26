package com.group.taskservice.controller;

import com.group.taskservice.dto.CreateTaskDTO;
import com.group.taskservice.dto.ScheduleTaskDTO;
import com.group.taskservice.model.Task;
import com.group.taskservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> findAllTasks() {
        return taskService.findAllTasks();
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody CreateTaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @PostMapping("/schedule")
    public Task scheduleTask(@RequestBody ScheduleTaskDTO taskDTO) {
        return taskService.scheduleTask(taskDTO);
    }

    @PutMapping("/{id}/start")
    public Task startTask(@PathVariable Long id) {
        return taskService.startTask(id);
    }

    @PutMapping("/{id}/finish")
    public Task finishTask(@PathVariable Long id) {
        return taskService.finishTask(id);
    }

}
