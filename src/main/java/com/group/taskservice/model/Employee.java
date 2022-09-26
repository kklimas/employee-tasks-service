package com.group.taskservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Timestamp registeredAt;
    private Timestamp lastLogin;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Task> tasks;
}
