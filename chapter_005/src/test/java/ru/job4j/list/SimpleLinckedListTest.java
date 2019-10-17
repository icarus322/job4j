package ru.job4j.list;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleLinckedListTest {

    private SimpleLinckedList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleLinckedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenAddThreeElementsAndDeleteTwoElementsThenUseGetSizeResultOne() {
        list.deleteLast();
        list.deleteLast();
        assertThat(list.getSize(), is(1));

    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(3));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }
}