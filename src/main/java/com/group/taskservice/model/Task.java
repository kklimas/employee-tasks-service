package com.group.taskservice.model;
import com.group.taskservice.enums.TaskStatus;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Builder
@Data
@RequiredArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    private String description;
    private Timestamp createdAt;
    private Timestamp deadLine;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
}
