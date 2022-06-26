package com.MonteCarlo.MonteCarlo.services;

import com.MonteCarlo.MonteCarlo.loginModels.User;
import com.MonteCarlo.MonteCarlo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ArrayList<User> getUsers(){
        return (ArrayList<User>)userRepository.findAll();
    }

    // It asks for user information and returns the user object (with id)
    public User addUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getById(Integer id){
        return userRepository.findById(id);
    }

    public boolean authenticateUser(User user){
        boolean authentication=false;

        for (User usr: getUsers()){
            if(usr.getName().equals(user.getName())){
                authentication=true;
                break;
            }
        }
        return authentication;

    }

    // TryCatch in case ID doesn't exist
    public boolean deleteUser(Integer id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }



}
