package com.app.BlopApplication.service;

import com.app.BlopApplication.Controller.UserController;
import com.app.BlopApplication.model.User;
import com.app.BlopApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //Contains all the business logic and communicate to database.

    //__________________________________________________________________________________________________________________

    //Hard Coded Content

    @Autowired
    private UserRepository userRepository;
    public User login(User user){
        /*if(user.getUsername().equals("Dikshant") && user.getPassword().equals("chitkara"))
            return true;
        else
            return false;*/
        User existingUser=userRepository.checkCredentials(user.getUsername(),user.getPassword());
        if(existingUser==null){
            return null;
        }
        else{
            return existingUser;
        }


    }
    //__________________________________________________________________________________________________________________


    public void registerUser(User newUser){
        userRepository.registerUser(newUser);
    }
}
