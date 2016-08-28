package com.codekul.ecommerce.controller;

import com.codekul.ecommerce.domain.User;
import com.codekul.ecommerce.repository.UserRepository;
import com.codekul.ecommerce.tool.FileTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by aniruddha on 31/7/16.
 */
@RestController
public class LoginController {

    @Autowired
    private UserRepository repository;

    @Autowired
    @Qualifier(value = "myTool")
    private FileTool tool ;

    @Autowired
    public LoginController(@Qualifier(value = "myTool")FileTool tool){
        this.tool = tool;
    }

    @Autowired
    public void setTool(@Qualifier(value = "myTool")FileTool tool) {
        this.tool = tool;
    }


    @GetMapping(value = "/user/sample",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Callable<ResponseEntity<?>> sampleUser(){

        return () ->{
            User user = new User();
            user.setId(10l);
            user.setPassword("android");
            user.setUserName("android");

            return new ResponseEntity<>(user,HttpStatus.OK);
        };
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> login(@RequestBody User user){

        ResponseEntity<HashMap<String,Object>> entity = null;

        HashMap<String,Object> map = new HashMap<>();

        try{
            if(repository.isValid(user.getUserName(),user.getPassword())){
                map.put("sts","success");
                map.put("msg","Login Success :)");
                entity = new ResponseEntity<>(map, HttpStatus.OK);
            }
            else {
                map.clear();

                map.put("sts","fail");
                map.put("msg","Login Failed :(");
                entity = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e){
            map.clear();

            map.put("sts","fail");
            map.put("msg","Login Failed :(");
            entity = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return entity;
    }


    @PostMapping(value = "/saveFile/{fileName}/{data}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private ResponseEntity<?> saveFile(@PathVariable("fileName") String f, @PathVariable String data){

        Map<String,Object> map =
                new HashMap<>();

        ResponseEntity<?> entity = null;
        try {

            tool.writeFile(f,data);
            map.put("sts","success");
            map.put("msg","File written successfully");

            entity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();

            map.put("sts","fail");
            map.put("msg","problem in saving file");

            entity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @RequestMapping(value = "/something")
    public ModelAndView getSomething(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("userName","android");

        return mav;
    }

    @PostMapping(value = "/user/new", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewUser(@RequestBody User user){

            System.out.println("User is - "+user);

            ResponseEntity<Map<String,Object>> entity = null;
            Map<String,Object> map = new HashMap<>();
            try {
                repository.insert(user);
                map.put("sts","success");
                entity = new ResponseEntity<>(map,HttpStatus.OK);
            }
            catch (Exception e){
                e.printStackTrace();
                map.put("sts","fail");
                entity = new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
            }
            return entity;
    }
}
