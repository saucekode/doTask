package com.app.dotask.controllers;

import com.app.dotask.dtos.ApiResponse;
import com.app.dotask.dtos.CreateUserDto;
import com.app.dotask.models.User;
import com.app.dotask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("create")
    public ResponseEntity<?> addNewUser(@RequestBody CreateUserDto newUser){
        userService.addNewUser(newUser);
        return new ResponseEntity<>(new ApiResponse(true, "User created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("all")
    public List<User> getUsers(){
       return userService.getUsers();
    }

    @GetMapping("{id}")
    public User getOneUser(@PathVariable("id") String id) throws Exception{
        return userService.getOneUser(id)
                .orElse(null);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") String id, @RequestBody User updatedUser) throws Exception{
        userService.updateUser(updatedUser,id);
        return new ResponseEntity<>(new ApiResponse(true, "User updated"), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOneUser(@PathVariable("id") String id) throws Exception {
        userService.deleteOneUser(id);
        return new ResponseEntity<>(new ApiResponse(true, "User deleted successfully"), HttpStatus.OK);
    }

    @DeleteMapping("all")
    public ResponseEntity<?> deleteAllUsers(@RequestBody User deleteUsers){
        userService.deleteAllUsers();
        return new ResponseEntity<>(new ApiResponse(true, "All users deleted"), HttpStatus.OK);
    }
}
