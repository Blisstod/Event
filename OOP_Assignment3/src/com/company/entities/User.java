package com.company.entities;

public class User {
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private double balance;
    public User(){}
    public User(String name, String surname, boolean gender, double balance) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setBalance(balance);
    }
    public User(int id, String name, String surname, boolean gender, double balance) {
        this(name, surname, gender, balance);
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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public boolean getGender() {
        return gender;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender + '\'' +
                ", balance=" + balance +
                '}';
    }
}
