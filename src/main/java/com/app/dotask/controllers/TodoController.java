package com.app.dotask.controllers;

import com.app.dotask.dtos.ApiResponse;
import com.app.dotask.dtos.CreateTodoDto;
import com.app.dotask.models.Todo;
import com.app.dotask.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo/")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping("create")
    public ResponseEntity<?> addNewTodo(@RequestBody CreateTodoDto newTodo){
        todoService.addNewTodo(newTodo);
        return new ResponseEntity<>(new ApiResponse(true, "Todo task successfully added"), HttpStatus.CREATED);
    }

    @GetMapping("all")
    public List<Todo> viewAllTodo(){
        return todoService.viewAllTodo();
    }

    @GetMapping("{id}")
    public Todo viewOneTodo(@PathVariable("id") String id) throws Exception {
        return todoService.viewOneTodo(id).orElse(null);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable("id") String id, @RequestBody Todo updatedTodo) throws Exception{
        todoService.updateTodo(updatedTodo, id);
        return new ResponseEntity<>(new ApiResponse(true, "Todo task is updated"), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") String id) throws Exception{
        todoService.deleteTodo(id);
        return new ResponseEntity<>(new ApiResponse(true,"Todo task deleted"), HttpStatus.OK);
    }

    @DeleteMapping("all")
    public ResponseEntity<?> deleteAllTodos(){
        todoService.deleteTodos();
        return new ResponseEntity<>(new ApiResponse(true,"All todo tasks deleted"), HttpStatus.OK);
    }
}
