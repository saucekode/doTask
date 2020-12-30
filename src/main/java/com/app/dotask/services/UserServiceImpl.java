package com.app.dotask.services;

import com.app.dotask.dtos.CreateUserDto;
import com.app.dotask.models.User;
import com.app.dotask.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addNewUser(CreateUserDto newUser){
        User saveUser = new User();
        saveUser.setFirstName(newUser.getFirstName());
        saveUser.setLastName(newUser.getLastName());
        saveUser.setEmail(newUser.getEmail());
        return saveUserToDB(saveUser);
    }

    private User saveUserToDB(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getOneUser(String id) throws Exception{
        if(userRepository.findUserById(id).isPresent()){
            return userRepository.findUserById(id);
        }else{
            throw new Exception("User not found");
        }
    }

    @Override
    public User updateUser(User updatedUser, String id) throws Exception{
        Optional<User> foundUser = userRepository.findUserById(id);
        if(foundUser.isPresent()){
            foundUser.get().setFirstName(updatedUser.getFirstName());
            foundUser.get().setLastName(updatedUser.getLastName());
            foundUser.get().setEmail(updatedUser.getEmail());
            foundUser.get().setPassword(updatedUser.getPassword());
            return saveUserToDB(foundUser.get());
        }else{
            throw new Exception("User not found");
        }
    }

    @Override
    public Optional<User> deleteOneUser(String id) throws Exception{
        if(userRepository.findUserById(id).isPresent()){
            return userRepository.deleteUserById(id);
        }else{
            throw new Exception("User not found");
        }
    }

    @Override
    public void deleteAllUsers(){
        userRepository.deleteAll();
    }
}
