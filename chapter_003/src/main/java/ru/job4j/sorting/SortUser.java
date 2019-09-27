package ru.job4j.sorting;

import java.util.*;

public class SortUser {

    public Set<User> sort(List<User> users) {
        Collections.sort(users);
        return new TreeSet<>(users);
    }

    public List<User> sortNameLength(List<User> users) {
        List<User> result = new ArrayList<>(users);
        Comparator<User> comparator = Comparator.comparingInt(o -> o.getName().length());
        result.sort(comparator);
        return result;
    }

    public List<User> sortByAllFields(List<User> users) {
        List<User> result = new ArrayList<>(users);
        Comparator<User> comparator = (o1, o2) -> {
            int rsl = o1.getName().compareTo(o2.getName());
            return rsl != 0 ? rsl : (o1.getAge() - o2.getAge());
        };
        result.sort(comparator);
        return result;
    }

}
