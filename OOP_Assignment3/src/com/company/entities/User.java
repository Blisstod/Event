package com.company.entities;

public class User extends Human {
    private double balance;
    private String login;
    private String password;

    public User(){}

    public User(double balance){
        setBalance(balance);
    }

    public User(String login, String password){
        setLogin(login);
        setPassword(password);
    }

    public User(int id,String login,String password,  String name, String surname, Double balance) {
        setId(id);
        setLogin(login);
        setPassword(password);
        setName(name);
        setSurname(surname);
        setBalance(balance);
    }

    public User(String login, String password, String name, String surname, double balance) {
        setLogin(login);
        setPassword(password);
        setName(name);
        setSurname(surname);
    }

    public void setBalance(double balance) {
        this.balance = balance;
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

    public void pay(double price) {
        this.balance = balance - price;
    }

    public void refund(double price) {
        this.balance = balance + price;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "User{" +
                ", id='" + getId() + '\'' +
                ", login='" + getLogin() + '\'' +
                ", password=" + getPassword() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", balance=" + balance +
                '}';
    }
}