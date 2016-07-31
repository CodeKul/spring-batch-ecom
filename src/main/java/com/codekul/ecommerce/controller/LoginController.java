package com.codekul.ecommerce.controller;

import com.codekul.ecommerce.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by aniruddha on 31/7/16.
 */
@RestController
public class LoginController {

    @RequestMapping(method = RequestMethod.POST, value = "/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HashMap<String,Object>> login(@RequestBody User user){

        ResponseEntity<HashMap<String,Object>> entity = null;

        HashMap<String,Object> map = new HashMap<>();
        if(user.getUserName().equals("android") && user.getPassword().equals("android")){
            map.put("sts","success");
            map.put("msg","Login Success :)");
            entity = new ResponseEntity<>(map, HttpStatus.OK);
        }
        else{
            map.clear();

            map.put("sts","fail");
            map.put("msg","Login Failed :(");
            entity = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}
