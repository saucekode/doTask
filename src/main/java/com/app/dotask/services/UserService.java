package com.app.dotask.services;

import com.app.dotask.dtos.CreateUserDto;
import com.app.dotask.models.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    // Add a new user by passing data via DTO to protect some fields
    User addNewUser(CreateUserDto newUser);

    // Get all users
    List<User> getUsers();

    // Get just one user
    Optional<User> getOneUser(String id) throws Exception;

    // Update a user info
    User updateUser(User updatedUser, String id) throws Exception;

    // Delete a user
    Optional<User> deleteOneUser(String id) throws Exception;

    // Delete all users
    public void deleteAllUsers();
}
