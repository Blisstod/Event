package com.company;


import com.company.controllers.EventController;
import com.company.controllers.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EventApplication {
    private final UserController userController;
    private final EventController eventController;
    private final Scanner scanner;
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to Our Event Application");
            System.out.println("Select option:");
            System.out.println("1. Create user");
            System.out.println("2. List of all events");
            System.out.println("3. Register to event");
            System.out.println("4. Crete an event");
            System.out.println("0. Exit");
            System.out.println();


            System.out.println("*************************");

        }
    }
}
