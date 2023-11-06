package me.arkantrust.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task implements Comparable<Task> {

    private Integer id;
    private String title;
    private String details;
    private Priority priority;
    private LocalDate dueDate;

    public Task(String title, String details, Priority priority, LocalDate dueDate) {

        this.title = title;
        this.details = details;
        this.priority = priority;
        this.dueDate = dueDate;

    }

    public Task(String title, String details, LocalDate dueDate) {

        this.title = title;
        this.details = details;
        this.priority = Priority.NONE;
        this.dueDate = dueDate;

    }

    public Task(String title, String details) {

        this.title = title;
        this.details = details;
        this.priority = Priority.NONE;
        this.dueDate = LocalDate.now();

    }

    public Task(String title, String details, Priority priority) {

        this.title = title;
        this.details = details;
        this.priority = priority;
        this.dueDate = LocalDate.now();

    }

    @Override
    public int compareTo(Task task) {

        return this.priority.compareTo(task.getPriority());

    }

    @Override
    public String toString() {

        return this.title;

    }

}
