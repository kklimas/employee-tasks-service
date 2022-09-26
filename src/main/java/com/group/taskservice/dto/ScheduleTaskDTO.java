package com.group.taskservice.dto;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class ScheduleTaskDTO {
    Long employeeId;
    Long taskId;
    Timestamp deadLine;
}
