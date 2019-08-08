package ru.job4j.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenSortUsersByAge() {
        List<User> users = new ArrayList<>();
        users.add(new User(15, "Tom"));
        users.add(new User(8, "Keil"));
        users.add(new User(58, "Rim"));
        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(users);
        Set<User> check = new TreeSet<>();
        check.add(new User(8, "Keil"));
        check.add(new User(15, "Tom"));
        check.add(new User(58, "Rim"));
        assertThat(check, is(result));
    }
}
