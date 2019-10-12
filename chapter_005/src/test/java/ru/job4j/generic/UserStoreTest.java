package ru.job4j.generic;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class UserStoreTest {

    private UserStore us;

    @Before
    public void beforeTest() {
        us = new UserStore(new User[5]);
        us.add(new User("0"));
        us.add(new User("1"));
        us.add(new User("2"));
        us.add(new User("3"));
    }

    @Test
    public void add() {
        SimpleArray<User> expect = new SimpleArray<>(new User[5]);
        expect.add(new User("0"));
        expect.add(new User("1"));
        expect.add(new User("2"));
        expect.add(new User("3"));
        assertThat(us.getArray(), is(expect));
    }

    @Test
    public void replace() {
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
        us.delete("2");
        SimpleArray<User> expect = new SimpleArray<>(new User[5]);
        expect.add(new User("0"));
        expect.add(new User("1"));
        expect.add(new User("3"));
        assertThat(us.getArray(), is(expect));

    }

    @Test
    public void findById() {
        assertThat(us.findById("1"), is(new User("1")));
    }
}