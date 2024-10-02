package com.example.demo;

import java.time.LocalDateTime;

public class Todo {
    private int id;
    private String task;
    private boolean status;
    private LocalDateTime createdAt;

    public Todo(int id, String task, boolean status, LocalDateTime createdAt) {
        this.id = id;
        this.task = task;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean isStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

