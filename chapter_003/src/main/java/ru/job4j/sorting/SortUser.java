package ru.job4j.sorting;

import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> users) {
        Collections.sort(users);
        Set<User> result = new TreeSet<>(users);
        return result;
    }

    public List<User> sortNameLength(List<User> users) {
        List<User> result = new ArrayList<>(users);
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        Collections.sort(result, comparator);
        return result;
    }

    public List<User> sortByAllFields(List<User> users) {
        List<User> result = new ArrayList<>(users);
        Comparator<User> comparator = new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int rsl = o1.getName().compareTo(o2.getName());
                return rsl != 0 ? rsl : (o1.getAge() - o2.getAge());
            }
        };
        Collections.sort(result, comparator);
        return result;
    }

}
