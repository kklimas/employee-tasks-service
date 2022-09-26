package com.group.taskservice.dto;

import com.group.taskservice.model.Employee;
import com.group.taskservice.model.Task;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class EmployeeDetailsDTO {
    private Employee employee;
    private List<Task> tasks;
}
