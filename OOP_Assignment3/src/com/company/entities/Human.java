package com.company.entities;

public abstract class Human {
    private int id;
    private String login;
    private String password;
    private String name;
    private String surname;

    public Human(){}

    public Human(String login, String password){
        setLogin(login);
        setPassword(password);
    }

    public Human(int id, String login, String password, String name, String surname) {
        setId(id);
        setLogin(login);
        setPassword(password);
        setName(name);
        setSurname(surname);
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
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
                ", login='" + login + '\'' +
                ", password=" + password +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
    public abstract void pay(double price);
}