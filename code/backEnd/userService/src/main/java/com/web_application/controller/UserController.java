package com.web_application.controller;

import com.web_application.model.User;
import com.web_application.service.Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {

   private Service service;
    @Autowired

    public UserController(Service service){
        this.service = service;
    }


    @GetMapping("getAll")
    public ResponseEntity<Object>  getUsers(){
        return service.getUsers();
    }
    @GetMapping("get/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id){
        return service.getUser(id);
    }

    @PostMapping("create")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        return service.createUser(user);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable Long id,@RequestBody User user){
        return service.updateUser(id,user);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        return service.deleteUser(id);
    }

}
