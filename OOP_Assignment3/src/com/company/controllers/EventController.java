package com.company.controllers;

import com.company.entities.Event;
import com.company.entities.User;
import com.company.repositories.EventRepositories;
import com.company.repositories.interfaces.IEventRepositories;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class EventController {
    private final IEventRepositories eventRepositories;
    public EventController(IEventRepositories eventRepositories){
        this.eventRepositories = eventRepositories;
    }
    public String CreateEvent(String name, double price, String description, LocalDate date){
        Event event = new Event(name, price, description, date);
        boolean created = eventRepositories.CreateEvent(event);
        return (created ? "Event was created" : "Event creation was failed!");
    }
    public String DeleteEvent(int id) {
        List<Event> events = eventRepositories.getAllEvents();
        for (Event event : events) {
            if (event.getId()==id){
                boolean deleted = eventRepositories.DeleteEvent(event);
                return (deleted ? "Event was deleted": "Event deletion was failed!");
            }
        }
        return "There is no events with this ID";
    }
    public Event FindEvent(int id){
        List<Event> events = eventRepositories.getAllEvents();
        Event regisEvent = new Event();
        for (Event event : events) {
            if (event.getId()==id){
                regisEvent = event;
                break;
            }
        }
        return regisEvent;
    }
    public String getEventById(int eventId){
        Event event = eventRepositories.getEventById(eventId);
        return event.toString();
    }
    public String getAllEvents(){
        List<Event> events = eventRepositories.getAllEvents();
        if (events.size() == 0)
            return "There is no any events!" + '\n' + "You need add your own event or wait for other events!";
        return events.toString();
    }
    public List<Event> getEvents() {
        List<Event> events = eventRepositories.getAllEvents();
        return events;
    }
}
