package ru.job4j.generic;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class UserStoreTest {

    @Test
    public void add() {
        UserStore us = new UserStore(new User[5]);
        us.add(new User("0"));
        us.add(new User("1"));
        us.add(new User("2"));
        us.add(new User("3"));
        SimpleArray<User> expect = new SimpleArray<>(new User[5]);
        expect.add(new User("0"));
        expect.add(new User("1"));
        expect.add(new User("2"));
        expect.add(new User("3"));
//        User[] expect = new User[]{new User("0"),
//                new User("1"),
//                new User("2"),
//                new User("3"),
//                new User(null)};
        assertThat(us.getArray(), is(expect));
    }

    @Test
    public void replace() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findById() {
    }
}