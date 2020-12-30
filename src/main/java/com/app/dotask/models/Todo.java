package com.app.dotask.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "todos")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Todo {
    @Id
    private String id;
    private String task;
    private String todoStatus;
    private LocalDateTime dateTime;
//    private List<Todo> todoList = new ArrayList<>();
}
