package com.web_application.service;

import com.web_application.model.User;
import com.web_application.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.web_application.constants.ApplicationConstants.*;

@Slf4j
@org.springframework.stereotype.Service
public class Service {
    @Autowired
    UserRepository userRepository;
    
    public Service(){
        
    }
    
    public ResponseEntity<User> createUser(User user){
        try {
            log.info("creating the user {}",user.toString());
            User result = userRepository.save(user);
            return new ResponseEntity(result, HttpStatus.CREATED);
        }catch (Exception ex){
            log.error(GENEXCEPTIONMSG+" "+ex.getMessage());
            return new ResponseEntity(GENEXCEPTIONMSG, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<User>> getUsers(){
        try{
            List<User> users = userRepository.findAll();
            return new ResponseEntity(users,HttpStatus.OK);
        }catch (Exception ex){
            log.error(GENEXCEPTIONMSG+" "+ex.getMessage());
            return new ResponseEntity(GENEXCEPTIONMSG,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
