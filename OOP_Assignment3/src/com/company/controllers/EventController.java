package com.company.controllers;

import com.company.entities.Event;
import com.company.repositories.EventRepositories;
import com.company.repositories.interfaces.IEventRepositories;

import java.util.ArrayList;
import java.util.List;

public class EventController {
    private final IEventRepositories eventRepositories;
    public EventController(IEventRepositories eventRepositories){
        this.eventRepositories = eventRepositories;
    }
    public String CreateEvent(String name, double price, String description){
        Event event = new Event(name, price, description);
        boolean created = eventRepositories.CreateEvent(event);
        return (created ? "Event was created" : "Event creation was failed!");
    }
    public String getAllEvents(){
        List<Event> events = eventRepositories.getAllEvents();
        return events.toString();
    }
}
