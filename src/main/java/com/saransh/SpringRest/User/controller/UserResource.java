package com.saransh.SpringRest.User.controller;

import com.saransh.SpringRest.User.dao.UserDaoService;
import com.saransh.SpringRest.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return userDaoService.findOne(id);
    }


}
