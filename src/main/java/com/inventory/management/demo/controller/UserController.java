package com.inventory.management.demo.controller;

import com.inventory.management.demo.repository.UserRepository;
import com.inventory.management.demo.entity.UserRecord;
import com.inventory.management.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(value ="/users/{uid}",produces =APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRecord> getUser(@PathVariable String uid){
        return service.getUser(uid);
    }

    @GetMapping(value ="/users",produces =APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserRecord>> getAllUser(){
        return service.getAllUser();
    }

    @PostMapping(value ="/users",produces =APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRecord> addUser(@RequestBody UserRecord record)
    {
        return service.addUser(record);
    }
}
