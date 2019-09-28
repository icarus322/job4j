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
        users.add(new User(15, "111"));
        users.add(new User(8, "222"));
        users.add(new User(58, "333"));
        SortUser sortUser = new SortUser();
        Set<User> result = sortUser.sort(users);
        Set<User> check = Set.of(
                new User(8, "111"),
                new User(15, "222"),
                new User(58, "333")
        );
        assertThat(result, is(check));
    }

    @Test
    public void whenSortUsersByNameLength() {
        List<User> users = new ArrayList<>();
        users.add(new User(15, "Rimer"));
        users.add(new User(8, "Keil"));
        users.add(new User(58, "Tom"));
        SortUser sortUser = new SortUser();
        List<User> result = sortUser.sortNameLength(users);
        List<User> check = List.of(
                new User(58, "Tom"),
                new User(8, "Keil"),
                new User(15, "Rimer")
        );
        assertThat(result, is(check));
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
        List<User> check = List.of(
                new User(8, "Keil"),
                new User(24, "Keil"),
                new User(15, "Tom"),
                new User(58, "Tom")
        );
        assertThat(result, is(check));
    }
}
