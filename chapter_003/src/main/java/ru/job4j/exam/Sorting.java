package ru.job4j.exam;

import java.util.*;


public class Sorting {

    Set <User> users = new HashSet<>();

    public void addUser(User user) {
        users.add(user);
    }


    public List<User> sortUsersFromA() {
        List<User> list = new ArrayList<>(users);
        Comparator<User> comparator = (o1, o2) -> {
            int result;
            if (o1 == null) {
                result = -1;
            }
            else if (o2 == null) {
                result = 1;
            }
            else if (o1.getFirstName().equals(o2.getFirstName())) {
                result = (o1.getSecondName().compareTo(o2.getSecondName()));
            }
            else {
                result = o1.getFirstName().compareTo(o2.getFirstName());
                           }
            return result;
        };
        list.sort(comparator);
        System.out.println(list);
        return list;
    }
    public List<User> sortUsersFromZ() {
        List<User> list = new ArrayList<>(users);
        Comparator<User> comparator = (o1, o2) -> {
            int result;
            if (o1 == null) {
                result = -1;
            }
            else if (o2 == null) {
                result = 1;
            }
            else if (o1.getFirstName().equals(o2.getFirstName())) {
                result = (o1.getSecondName().compareTo(o2.getSecondName()));
            }
            else {

                result = (o1.getFirstName().compareTo(o2.getFirstName())) * - 1;
            }

            return result;
        };
        list.sort(comparator);
        System.out.println(list);
        return list;
    }

    @Override
    public String toString() {
        return "Sorting{" +
                "users=" + users +
                '}';
    }
}
