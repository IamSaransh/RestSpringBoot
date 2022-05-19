package com.saransh.SpringRest.User.controller;

import com.saransh.SpringRest.User.dao.UserDaoService;
import com.saransh.SpringRest.User.exception.UserNotFoundException;
import com.saransh.SpringRest.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping("/v1/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping("/v1/users/{id}")
    public User retrieveUsersById(@PathVariable int id){
        User foundUser =  userDaoService.findOne(id);
        if(foundUser==null)
            throw new UserNotFoundException("User Not Found!");
        return foundUser;
    }
    @PostMapping("/v1/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        User savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @DeleteMapping("/v1/users/{id}")
    public void deleteUser(@PathVariable int id){
        User deletedUser = userDaoService.deleteUserById(id);
        if(deletedUser==null)
                throw new UserNotFoundException("User not found in DB. Delete Failed!");
    }


}
