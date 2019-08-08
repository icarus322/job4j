package ru.job4j.sorting;

public class User implements Comparable<User> {

    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(User user) {
        return this.age - user.age;
    }

}
