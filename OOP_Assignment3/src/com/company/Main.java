package com.company;

import com.company.controllers.EventController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.EventRepositories;
import com.company.repositories.interfaces.IEventRepositories;


public class Main {
    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IEventRepositories eventRepositories = new EventRepositories(db);
        EventController eventController = new EventController(eventRepositories);
        EventApplication app = new EventApplication(eventController);
        app.start();
    //abay abay abay abay
    }
}
