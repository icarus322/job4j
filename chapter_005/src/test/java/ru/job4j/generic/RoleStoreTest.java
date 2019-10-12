package ru.job4j.generic;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class RoleStoreTest {

    private RoleStore role;

    @Before
    public void beforeTest() {
        role = new RoleStore(new Role[5]);
        role.add(new Role("0"));
        role.add(new Role("1"));
        role.add(new Role("2"));
        role.add(new Role("3"));
    }

    @Test
    public void add() {
        SimpleArray<Role> expect = new SimpleArray<>(new Role[5]);
        expect.add(new Role("0"));
        expect.add(new Role("1"));
        expect.add(new Role("2"));
        expect.add(new Role("3"));
        assertThat(role.getArray(), is(expect));
    }

    @Test
    public void replace() {
        role.replace("2", new Role("999"));
        SimpleArray<Role> expect = new SimpleArray<>(new Role[5]);
        expect.add(new Role("0"));
        expect.add(new Role("1"));
        expect.add(new Role("999"));
        expect.add(new Role("3"));
        assertThat(role.getArray(), is(expect));

    }

    @Test
    public void delete() {
        role.delete("2");
        SimpleArray<Role> expect = new SimpleArray<>(new Role[5]);
        expect.add(new Role("0"));
        expect.add(new Role("1"));
        expect.add(new Role("3"));
        assertThat(role.getArray(), is(expect));

    }

    @Test
    public void findById() {
        assertThat(role.findById("1"), is(new Role("1")));
    }
    
}