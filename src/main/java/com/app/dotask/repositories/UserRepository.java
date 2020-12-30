package com.app.dotask.repositories;

import com.app.dotask.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Find all users
    List<User> findAll();

    // Find user by id
    Optional<User> findUserById(String id);

    // Delete user by id
    Optional<User> deleteUserById(String id);

    // Delete all users
    public void deleteAll();
}
