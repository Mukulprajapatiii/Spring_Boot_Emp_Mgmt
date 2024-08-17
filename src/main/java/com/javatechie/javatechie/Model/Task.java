package com.javatechie.javatechie.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id

    private String taskId;
    private String description;
    private int security;
    private String assignee;
    private int StoryPoint;
}
