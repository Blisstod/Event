package com.company;

import com.company.controllers.EventController;
import com.company.controllers.UserController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.EventRepositories;
import com.company.repositories.UserRepository;
import com.company.repositories.interfaces.IEventRepositories;
import com.company.repositories.interfaces.IUserRepository;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IEventRepositories eventRepositories = new EventRepositories(db);
        IUserRepository userRepository = new UserRepository(db);
        EventController eventController = new EventController(eventRepositories)
        UserController userController = new UserController(userRepository);
        EventApplication app = new EventApplication(controller);
        app.start();
    }
}