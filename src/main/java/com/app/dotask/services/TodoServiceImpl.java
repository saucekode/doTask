package com.app.dotask.services;

import com.app.dotask.dtos.CreateTodoDto;
import com.app.dotask.models.Todo;
import com.app.dotask.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService{
    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo addNewTodo(CreateTodoDto newTodo){
        Todo saveTodo = new Todo();
        saveTodo.setTask(newTodo.getTask());
        saveTodo.setTodoStatus(newTodo.getTodoStatus());
        saveTodo.setDateTime(LocalDateTime.now());
        return saveTodoToDB(saveTodo);
    }

    private Todo saveTodoToDB(Todo todo){
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> viewAllTodo(){
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> viewOneTodo(String id) throws Exception{
        if(todoRepository.findTodoById(id).isPresent()){
            return todoRepository.findTodoById(id);
        }else{
            throw new Exception("Todo task not found");
        }
    }

    @Override
    public Todo updateTodo(Todo updatedTodo, String id) throws Exception{
        Optional<Todo> foundTask = todoRepository.findTodoById(id);
        if(foundTask.isPresent()){
            foundTask.get().setTask(updatedTodo.getTask());
            foundTask.get().setTodoStatus(updatedTodo.getTodoStatus());
            foundTask.get().setDateTime(LocalDateTime.now());
            return saveTodoToDB(foundTask.get());
        }else{
            throw new Exception("Task not found");
        }
    }

    @Override
    public Optional<Todo> deleteTodo(String id) throws Exception{
        if(todoRepository.findTodoById(id).isPresent()){
            return todoRepository.deleteTodoById(id);
        }else{
            throw new Exception("Todo task not found");
        }
    }

    public void deleteTodos(){
        todoRepository.deleteAll();
    }
}
