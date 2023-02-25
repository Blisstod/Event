package com.company.controllers;

import com.company.entities.Event;
import com.company.entities.User;
import com.company.repositories.RegisEventRepositories;

import java.util.ArrayList;
import java.util.List;

public class RegisterEventController {
    private final RegisEventRepositories regisEventRepositories;
    public RegisterEventController(RegisEventRepositories regisEventRepositories){
        this.regisEventRepositories = regisEventRepositories;
    }

    public boolean registerEvent(Event event, User user){
        if(event.getPrice()<= user.getBalance()) {
            double userBalancePayed = user.pay(event.getPrice());
            regisEventRepositories.register(user.getId(), event.getId(), userBalancePayed);
            return true;
        }
        return false;
    }
    public boolean refundEvent(Event eventToRefund, User user){
        double userBalanceRefunded = user.refund(eventToRefund.getPrice());
        regisEventRepositories.unregister(user.getId(),eventToRefund.getId(), userBalanceRefunded);
        return true;
    }
    public List<Integer> getRegisteredEvents (int userId){
        return regisEventRepositories.getAllRegisEvents( userId);
    }

}
