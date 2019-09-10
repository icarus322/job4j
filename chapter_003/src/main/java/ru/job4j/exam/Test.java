package ru.job4j.exam;

public class Test {
    public void start() {
        Sorting sorting = new Sorting();
        sorting.addUser(new User("Tom", "Hall"));
        sorting.addUser(new User("Fred", "Brown"));
        sorting.addUser(new User("Alex", "Wilson"));
        sorting.addUser(new User("Tom", "Brown"));
        sorting.addUser(new User("Alex", "Hall"));
        sorting.sortUsersFromA();
        sorting.sortUsersFromZ();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.start();
    }
}
