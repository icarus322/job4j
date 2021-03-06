package ru.job4j.exam;

import java.util.List;

public class Test {
    public void start() {
        Sorting sorting = new Sorting();
        sorting.addDepartment(new Organization(List.of("K2")));
        sorting.addDepartment(new Organization(List.of("K1", "SK1", "SSK2")));
        sorting.addDepartment(new Organization(List.of("K1", "SK1")));
        sorting.addDepartment(new Organization(List.of("K1", "SK2")));
        sorting.addDepartment(new Organization(List.of("K1")));
        sorting.addDepartment(new Organization(List.of("K1", "SK1", "SSK1")));
        sorting.addDepartment(new Organization(List.of("K2", "SK1", "SSK1")));
        sorting.addDepartment(new Organization(List.of("K2", "SK1", "SSK2")));
        sorting.addDepartment(new Organization(List.of("K2", "SK1")));

        sorting.sortOrgsFromA();
//        sorting.sortOrgsFromZ();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.start();
    }

}
