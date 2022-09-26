package com.group.taskservice.service;

import com.group.taskservice.enums.TaskStatus;
import com.group.taskservice.dto.CreateTaskDTO;
import com.group.taskservice.dto.ScheduleTaskDTO;
import com.group.taskservice.model.Employee;
import com.group.taskservice.model.Task;
import com.group.taskservice.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final EmployeeService employeeService;

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(CreateTaskDTO taskDTO) {
        var employee = employeeService.findEmployeeById(taskDTO.getEmployeeId());
        var date = new Date();
        return taskRepository.save(
                Task.builder()
                        .name(taskDTO.getName())
                        .description(taskDTO.getDescription())
                        .status(TaskStatus.CREATED)
                        .employee(employee.getEmployee())
                        .createdAt(new Timestamp(date.getTime()))
                        .build()
        );
    }

    public Task scheduleTask(ScheduleTaskDTO taskDTO) {
        var task = taskRepository.findById(taskDTO.getTaskId()).orElseThrow();
        var employee = employeeService.findEmployeeById(taskDTO.getEmployeeId());

        task.setEmployee(employee.getEmployee());
        task.setStatus(TaskStatus.SCHEDULED);

        return taskRepository.save(task);
    }

    public Task startTask(Long taskId) {
        var task = taskRepository.findById(taskId).orElseThrow();
        task.setStatus(TaskStatus.IN_PROGRESS);

        return taskRepository.save(task);
    }

    public Task finishTask(Long taskId) {
        var task = taskRepository.findById(taskId).orElseThrow();
        task.setStatus(TaskStatus.DONE);

        return taskRepository.save(task);
    }

    public List<Task> findTasksByEmployeeId(Employee employee) {
        return taskRepository.findTaskByEmployee(employee);
    }
}
