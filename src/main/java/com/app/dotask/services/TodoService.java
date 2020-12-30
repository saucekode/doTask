package com.app.dotask.services;

import com.app.dotask.dtos.CreateTodoDto;
import com.app.dotask.models.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    Todo addNewTodo(CreateTodoDto newTodo);

    List<Todo> viewAllTodo();

    Optional<Todo> viewOneTodo(String id) throws Exception;

    Todo updateTodo(Todo updatedTodo, String id) throws Exception;

    Optional<Todo> deleteTodo(String id) throws Exception;

    public void deleteTodos();
}
