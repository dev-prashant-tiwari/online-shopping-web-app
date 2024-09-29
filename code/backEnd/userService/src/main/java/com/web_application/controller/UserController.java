package com.web_application.controller;

import com.web_application.model.User;
import com.web_application.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
   private Service service;


    @GetMapping("getAll")
    public ResponseEntity<List<User>>  getUsers(){
        return service.getUsers();
    }

    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        //User user = (User) request.getBody();
        return service.createUser(user);
    }

}
