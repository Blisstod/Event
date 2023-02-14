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
    public String AuthorizeUser(User user ){
        boolean valid = usersRepositories.ValidUser(user);
        return (valid ? "Logged in." : "Incorrect password or login.!");
    }
//    public Event FindEvent(int id){
//        List<Event> events = eventRepositories.getAllEvents();
//        Event regisEvent = new Event();
//        for (Event event : events) {
//            if (event.getId()==id){
//                regisEvent = event;
//                break;
//            }
//        }
//        return regisEvent;
//    }
    public String getAllUsers(){
        List<User> users = usersRepositories.getAllUsers();
        if (users.size() == 0)
            return "There isn't any users!" + '\n' + "You need add your own event or wait for other events!";
        return users.toString();
    }
}
