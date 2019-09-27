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
        List<User> users = List.of(
                new User(15, "Tom"),
                new User(8, "Keil"),
                new User(58, "Rim")
        );
//        List<User> users = new ArrayList<>();
//        users.add(new User(15, "Rim"));
//        users.add(new User(8, "Keil"));
//        users.add(new User(58, "Tom"));
        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(users);
        Set<User> check = new TreeSet<>();
        check.add(new User(8, "Keil"));
        check.add(new User(15, "Tom"));
        check.add(new User(58, "Rim"));
        assertThat(check, is(result));
    }

    @Test
    public void whenSortUsersByNameLength() {
        List<User> users = new ArrayList<>();
        users.add(new User(15, "Rimer"));
        users.add(new User(8, "Keil"));
        users.add(new User(58, "Tom"));
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortNameLength(users);
        List<User> check = new ArrayList<>();
        check.add(new User(58, "Tom"));
        check.add(new User(8, "Keil"));
        check.add(new User(15, "Rimer"));
        assertThat(check, is(result));
    }

    @Test
    public void whenSortUsersByAllFields() {
        List<User> users = new ArrayList<>();
        users.add(new User(15, "Tom"));
        users.add(new User(8, "Keil"));
        users.add(new User(58, "Tom"));
        users.add(new User(24, "Keil"));
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortByAllFields(users);
        List<User> check = new ArrayList<>();
        check.add(new User(8, "Keil"));
        check.add(new User(24, "Keil"));
        check.add(new User(15, "Tom"));
        check.add(new User(58, "Tom"));
        assertThat(check, is(result));
    }
}
