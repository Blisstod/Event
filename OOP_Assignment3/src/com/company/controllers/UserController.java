package com.company.controllers;

import com.company.entities.Event;
import com.company.entities.User;
import com.company.repositories.UsersRepositories;
import com.company.repositories.interfaces.IEventRepositories;

import java.util.List;

public class UserController {
    private final UsersRepositories usersRepositories;
    public UserController(UsersRepositories usersRepositories){
        this.usersRepositories = usersRepositories;
    }
    public String CreateUser(User user){
        boolean created = usersRepositories.CreateUser(user);
        return (created ? "User was created" : "User creation failed!");
    }
    public User SignIn(User userToCheck){
        User user = usersRepositories.SignIn(userToCheck);
        return user;
    }
    public boolean isExist(User user){
        return (usersRepositories.isExist(user)) ? true : false;
    }
    public String getAllUsers(){
        List<User> users = usersRepositories.getAllUsers();
        if (users.size() == 0)
            return "There isn't any users!" + '\n' + "You need add your own event or wait for other events!";
        return users.toString();
    }
}
