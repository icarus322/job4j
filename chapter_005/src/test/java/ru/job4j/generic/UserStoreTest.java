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
        assertThat(us.getArray(), is(expect));
    }

    @Test
    public void replace() {
        UserStore us = new UserStore(new User[5]);
        us.add(new User("0"));
        us.add(new User("1"));
        us.add(new User("2"));
        us.add(new User("3"));
        us.replace("2", new User("999"));
        SimpleArray<User> expect = new SimpleArray<>(new User[5]);
        expect.add(new User("0"));
        expect.add(new User("1"));
        expect.add(new User("999"));
        expect.add(new User("3"));
        assertThat(us.getArray(), is(expect));

    }

    @Test
    public void delete() {
    }

    @Test
    public void findById() {
    }
}