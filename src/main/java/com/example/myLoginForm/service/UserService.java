package com.example.myLoginForm.service;


import com.example.myLoginForm.model.User;
import com.example.myLoginForm.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User findById(Long id){
        return repository.getOne(id);
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    public User addUser(User u){
        return repository.save(u);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
