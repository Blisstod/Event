package com.company.entities;

public class User {
    private String name;
    private String surname;
    private double balance;
    public User(double balance){
        setBalance(balance);
    }
    public User(String name, String surname, double balance) {
        setName(name);
        setSurname(surname);
        setBalance(balance);
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


    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", balance=" + balance +
                '}';
    }
}
