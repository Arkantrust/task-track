package me.arkantrust.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    
    private String description;
    private Priority priority;
    private int duration;
    private LocalDateTime createdAt;

}
