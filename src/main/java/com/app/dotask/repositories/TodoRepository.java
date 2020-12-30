package com.app.dotask.repositories;

import com.app.dotask.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {
    // Find all todos created by one user
    List<Todo> findAll();

    // Find todos by Id
    Optional<Todo> findTodoById(String id);

    // Delete todos by Id
    Optional<Todo> deleteTodoById(String id);

    // Delete all todos
    public void deleteAll();
}
