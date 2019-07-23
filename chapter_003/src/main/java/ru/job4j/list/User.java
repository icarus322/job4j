package ru.job4j.list;

public class User {
    private String  id;
    private String name;
    private String city;

    public User() {
    }

    public User(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return this.id + this.name + this.city;
    }

    public String getId() {
        return id;
    }

}
