package com.codekul.ecommerce.controller;

import com.codekul.ecommerce.domain.UserData;
import com.codekul.ecommerce.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by aniruddha on 3/9/16.
 */
@RestController
public class LoginDataController {

    @Autowired
    private UserDataRepository repository;

    @CrossOrigin
    @PostMapping(value = "/data/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Callable<ResponseEntity<?>> loginWithData(@RequestBody  UserData user){
        return () -> {
            Map<String, Object> map = new HashMap<>();

            ResponseEntity<Map<String,Object>> entity = null;

            if(repository.findByUserNameAndPassword(user.getUserName(),user.getPassword()) != null){
                map.put("sts","success");
                entity = new ResponseEntity<>(map, HttpStatus.OK);
            }
            else{
                map.put("sts","fail");
                entity = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
            }
            return entity;
        };
    }
}
