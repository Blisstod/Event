package com.company.repositories.interfaces;

import com.company.entities.Event;

import java.util.List;

public interface IEventRepositories {
    boolean CreateEvent(Event event);


    boolean DeleteEvent(Event event);
    List<Event> getAllEvents();
    Event getEventById(int id);
}
