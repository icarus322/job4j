package ru.job4j.sorting;

import java.util.Objects;

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

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{"
                +
                "age="
                + age
                +
                ", name='"
                + name
                + '\''
                +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
