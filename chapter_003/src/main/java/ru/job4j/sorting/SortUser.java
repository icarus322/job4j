package ru.job4j.sorting;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortUser {

    public Set<User> sort(List<User> users) {
        Collections.sort(users);
        Set<User> result = new TreeSet<>(users);
        return result;
    }

}
