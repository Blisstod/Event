package com.company;


import com.company.controllers.EventController;
import com.company.controllers.RegisterEventController;
import com.company.entities.Event;
import com.company.entities.User;
import com.company.controllers.RegisterEventController;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EventApplication {
    private final EventController eventController;
    private RegisterEventController registerEventController;
    private final Scanner scanner;


    public EventApplication(EventController eventController, RegisterEventController registerEventController) {
        this.eventController = eventController;
        this.registerEventController =  registerEventController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println();
        System.out.println("You need register first");
        System.out.println("Please enter your name");
        String name = scanner.next();
        System.out.println("Please enter your surname");
        String surname = scanner.next();
        System.out.println("Please enter your balance");
        Double balance = scanner.nextDouble();

        User user = new User(name, surname, balance);
        System.out.println("User was created!");
        while (true) {

            System.out.println();
            System.out.println("Welcome to Our Event Application");
            System.out.println("Select option:");
            System.out.println("1. Show my balance");
            System.out.println("2. List of all events");
            System.out.println("3. Register to event");
            System.out.println("4. Show registered events");
            System.out.println("5. Refund the event");
            System.out.println("6. Crete an event");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    showMyBalance(user);
                } else if(option == 2){
                    getAllEventsMenu();
                } else if(option == 3){
                    registerToEvent(user);
                } else if(option == 4){
                    getRegisteredEvents();
                } else if(option == 5){
                    refundEvent(user);
                } else if (option == 6) {
                    createEventMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void showMyBalance(User user){
        System.out.println("Your balance is: ");
        System.out.println(user.getBalance());
    }
    public void createEventMenu(){
        System.out.println("Please enter event name");
        String name = scanner.next();
        System.out.println("Please enter price");
        Double price = scanner.nextDouble();
        System.out.println("Please write description about this event");
        String description = scanner.next();
        System.out.println("Please write year of this event");
        int year = scanner.nextInt();
        System.out.println("Please write month of this event");
        int month = scanner.nextInt();
        System.out.println("Please write day of this event");
        int day = scanner.nextInt();
        LocalDate date = LocalDate.of(year, month, day);

        String response = eventController.CreateEvent(name, price, description);
        System.out.println(response);
    }
    public void getAllEventsMenu(){
        String response = eventController.getAllEvents();
        System.out.println(response);
    }
    public void registerToEvent(User user){
        getAllEventsMenu();
        System.out.println("Choose event Id.");
        int regis_id = scanner.nextInt();
        Event eventToRegister = eventController.FindEvent(regis_id);
        if (registerEventController.registerEvent(eventToRegister, user))
            System.out.println("Succesfully registered to: " + eventToRegister.getName());
        else System.out.println("You do not have enough money to register " + eventToRegister.getName() + "!");
    }
    public void refundEvent(User user){
        if(registerEventController.getRegisteredEvents().isEmpty()){
            System.out.println("No registered events to refund.");
        }
        else {
            getRegisteredEvents();
            System.out.println("Choose event Id.");
            int refund_event_id = scanner.nextInt();
            Event eventToRefund = eventController.FindEvent(refund_event_id);
            System.out.println(registerEventController.refundEvent(eventToRefund, user)?
                    "Succesfully refunded event: " +eventToRefund.getName():"couldn refund the event:"+eventToRefund.getName()+".");
        }

    }
    public void getRegisteredEvents(){
        List<Event> registeredEvents = registerEventController.getRegisteredEvents();
        if(registeredEvents.isEmpty()){
            System.out.println("Nothing to show, register to event first.");
        }
        else {
            for (Event event : registeredEvents) {
                System.out.println(event.toString());
            }
        }
    }

}
