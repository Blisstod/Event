package com.company.entities;

public abstract class Human {
    private int id;
    private String name;
    private String surname;

    public Human(){}

    public void setId(int id){
        this.id=id;
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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Human{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
    public abstract void pay(double price);
}