package com.github.nazzrrg.simplespringangularapp.controller;

import com.github.nazzrrg.simplespringangularapp.UserRepository;
import com.github.nazzrrg.simplespringangularapp.model.User;
import com.github.nazzrrg.simplespringangularapp.controller.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/users")
    void create(@RequestBody User user) {
        service.create(user);
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable long id) {
        return service.getById(id);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable long id) {
        service.delete(id);
    }
}