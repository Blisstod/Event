package com.company.controllers;

import com.company.entities.Event;
import com.company.entities.User;
import com.company.repositories.RegisEventRepositories;

import java.util.ArrayList;

public class RegisterEventController {
//    private List<Event> registeredEvents = new ArrayList<>();
    private final RegisEventRepositories regisEventRepositories;
    public RegisterEventController(RegisEventRepositories regisEventRepositories){
        this.regisEventRepositories = regisEventRepositories;
    }

    public boolean registerEvent(Event event, User user){
        if(event.getPrice()<= user.getBalance()) {
            user.pay(event.getPrice());
            regisEventRepositories.register(user.getId(), event.getId());

            return true;
        }
        return false;
    }
    public boolean refundEvent(Event eventToRefund, User user){
        regisEventRepositories.unregister(user.getId(),eventToRefund.getId());
        user.refund(eventToRefund.getPrice());
        return true;
//        boolean index = false;
//        for (Event event : this.getRegisteredEvents()) {
//            if (event.getId()==eventToRefund.getId()){
//                index = true;
//                break;
//            }
//        }
//        if(index) {
//            user.refund(eventToRefund.getPrice());
//    //        this.registeredEvents.remove(event);
//            List <Event> refundedEvents = new ArrayList<>();
//            for (Event validEvent : registeredEvents) {
//                if (validEvent.getId()!=eventToRefund.getId()){
//                    refundedEvents.add(eventToRefund);
//                }
//            }
//            setRegisteredEvents(refundedEvents);
//            return true;
//        }
//        return false;
    }
    public ArrayList<Integer>  getRegisteredEvents (int userId){
        return regisEventRepositories.getAllRegisEvents( userId);
    }



}
