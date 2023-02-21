package com.company.entities;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Event {
    private int id;
    private String name;
    private double price;
    private String description;
    private LocalDate date;
    //private Calendar calendar = new GregorianCalendar();
    public Event(){}
    public Event(String name, double price, String description, LocalDate date /*Calendar calendar*/){
        setName(name);
        setPrice(price);
        setDescription(description);
        setDate(date);
    }
    public Event(int id, String name, double price, String description, LocalDate date /*Calendar calendar*/){
        this(name, price, description, date /*calendar*/);
        setId(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public LocalDate getDate() {
        return date;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" + id + " | " + name + " | " + price + " | " + description + " | " + date + "}" + '\n';
    }
    
}
