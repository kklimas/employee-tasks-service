package com.group.taskservice.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TaskStatus {

    CREATED("C"),
    SCHEDULED("S"),
    IN_PROGRESS("I"),
    DONE("D");

    private final String label;
}
