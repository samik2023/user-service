package com.inventory.management.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inventory.management.demo.entity.UserRecord;
import com.inventory.management.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository repository;


    public ResponseEntity<UserRecord> getUser(String uid){

        Optional<UserRecord> record = repository.findById(Long.valueOf(uid));
        return ResponseEntity.ok(record.get());
    }
    public ResponseEntity<List<UserRecord>> getAllUser(){
        List<UserRecord> orders = repository.findAll();
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    public ResponseEntity<UserRecord> addUser(UserRecord user){
        repository.save(user);
        log.info("User added  successfully !");
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    public ResponseEntity<String> deleteUser(String uid){
        repository.deleteById(Long.valueOf(uid));
        log.info("User deleted  successfully !");
        return ResponseEntity.ok("Order deleted");
    }
}
