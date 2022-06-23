package com.MonteCarlo.MonteCarlo.controllers;

import com.MonteCarlo.MonteCarlo.loginModels.User;
import com.MonteCarlo.MonteCarlo.loginModels.UserList;
import com.MonteCarlo.MonteCarlo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

//To specify this is a controller (URls)
@RestController
@RequestMapping (value="/user")
public class UserControllers {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping()
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<User> getUserByID (@PathVariable("id") Integer id){
        return this.userService.getById(id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Integer id){
        boolean ok = this.userService.deleteUser(id);
        if (ok){
            return "User with id: "+ id +" has been deleted";
        } else{
            return "Could not delete the User with id: " + id;
        }
    }

/*
    //Here the URL of this controller is specified
    @RequestMapping(value="user/newUser")
    public User createUsers(){
        User user = new User();
        user.setEmail("kotch.95@gmail.com");
        user.setLastName("Rojas");
        user.setName("Julian");
        user.setPhone("3046702385");
        user.setPassword("Julian123");
        user.setId(123456);
        UserList userList =UserList.getInstance();
        userList.addUser(user);
        return user;
    }

    @RequestMapping(value="user/get{id}")
    public User getUsers(@PathVariable double id){
        UserList userList =UserList.getInstance();
        User user = userList.getUserById(id);
        return user;
    }


    @RequestMapping(value="user/update")
    public User updateUsers(){
        User user = new User();
        user.setEmail("kotch.95@gmail.com");
        user.setLastName("Rojas");
        user.setName("Julian");
        user.setPhone("3046702385");
        user.setPassword("Julian123");
        return user;
    }
    @RequestMapping(value="user/delete{id}")

    public void deleteUsers(@PathVariable double id){
        UserList userList =UserList.getInstance();
        User user = userList.getUserById(id);
        userList.deleteUser(user);

    }
    */
}
