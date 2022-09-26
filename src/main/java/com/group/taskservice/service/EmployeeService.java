package com.group.taskservice.service;

import com.group.taskservice.dto.CreateEmployeeDTO;
import com.group.taskservice.dto.EmployeeDetailsDTO;
import com.group.taskservice.model.Employee;
import com.group.taskservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final TaskService taskService;
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(CreateEmployeeDTO employeeDTO) {
        var date = new Date();
        return  employeeRepository.save(
                Employee.builder()
                        .firstName(employeeDTO.getFirstName())
                        .lastName(employeeDTO.getLastName())
                        .registeredAt(new Timestamp(date.getTime()))
                        .build());
    }

    public EmployeeDetailsDTO findEmployeeById(Long id) {
        var employee = employeeRepository.findById(id).orElseThrow();
        var tasks = taskService.findTasksByEmployeeId(employee);
        return EmployeeDetailsDTO.builder()
                .employee(employee)
                .tasks(tasks)
                .build();
    }
}
