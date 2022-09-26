package com.group.taskservice.service;

import com.group.taskservice.model.Employee;
import com.group.taskservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        var list = employeeRepository.findAll();
        System.out.println(list.get(0));
        return list;
    }

    public Employee addEmployee(Employee employee) {
        return  employeeRepository.save(employee);
    }
}
