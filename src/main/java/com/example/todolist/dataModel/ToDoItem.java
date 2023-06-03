package com.example.todolist.dataModel;

import java.time.LocalDate;

public class ToDoItem {
    private String shortDescription;
    private String details;
    private LocalDate deadLine;
    private String status;

    public ToDoItem(String shortDescription, String details, LocalDate deadLine, String status) {
        this.shortDescription = shortDescription;
        this.details = details;
        this.deadLine = deadLine;
        this.status = status;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return shortDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
