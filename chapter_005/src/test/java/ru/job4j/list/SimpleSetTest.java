package ru.job4j.list;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test
    public void add() {
        SimpleSet<Integer> set = new SimpleSet<>(new Integer[5]);
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(3);
        Integer[] expect = new Integer[]{1, 2, 3, null, null};
        assertThat(set.getArray(), is(expect));
    }

    @Test(expected = NoSuchElementException.class)
    public void thenTestsIterator() {
        SimpleSet<Integer> set = new SimpleSet<>(new Integer[5]);
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(1));
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(2));
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(3));
        MatcherAssert.assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }
    @Test(expected = ConcurrentModificationException.class)
    public void thenModifyArray() {
        SimpleSet<Integer> set = new SimpleSet<>(new Integer[5]);
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(3);
        Iterator<Integer> iterator = set.iterator();
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(1));
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(2));
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(3));
        MatcherAssert.assertThat(iterator.hasNext(), is(false));
        set.add(4);
        iterator.next();
    }
}