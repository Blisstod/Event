package com.company.entities;

public class User {
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    public User(){}
    public User(String name, String surname, boolean gender) {
        setName(name);
        setSurname(surname);
        setGender(gender);
    }
    public User(int id, String name, String surname, boolean gender) {
        this(name, surname, gender);
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                '}';
    }
}
