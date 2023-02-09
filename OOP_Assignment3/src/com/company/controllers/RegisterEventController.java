package com.company.controllers;

import com.company.entities.Event;
import com.company.entities.User;

import java.util.ArrayList;
import java.util.List;

public class RegisterEventController {
    private List<Event> registeredEvents = new ArrayList<>();
    public RegisterEventController(){

    }
    public boolean registerEvent(Event event, User user){
        if(event.getPrice()<= user.getBalance()) {
            user.pay(event.getPrice());
            this.registeredEvents.add(event);
            return true;
        }
        return false;
    }
    public void refundEvent(Event event, User user){
        user.refund(event.getPrice());
//        this.registeredEvents.remove(event);
        List <Event> refundedEvents = new ArrayList<>();
        for (Event validEvent : registeredEvents) {
            if (validEvent.getId()!=event.getId()){
                refundedEvents.add(event);
            }
        }
        setRegisteredEvents(refundedEvents);
    }
    public List<Event> getRegisteredEvents (){
        return registeredEvents;
    }


    public void setRegisteredEvents(List<Event> registeredEvents) {
        this.registeredEvents = registeredEvents;
    }
}
