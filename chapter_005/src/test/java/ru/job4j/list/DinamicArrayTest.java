package ru.job4j.list;

import org.hamcrest.MatcherAssert;
import org.junit.Test;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DinamicArrayTest {

    @Test
    public void add() {
        DinamicArray<Integer> dinamic = new DinamicArray<>(new Integer[3]);
        dinamic.add(0);
        dinamic.add(1);
        dinamic.add(2);
        dinamic.add(3);
        Integer[] expect = new Integer[]{0, 1, 2, 3, null, null};
        assertThat(dinamic.getArray(), is(expect));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void get() {
        DinamicArray<Integer> dinamic = new DinamicArray<>(new Integer[3]);
        dinamic.add(0);
        dinamic.add(1);
        dinamic.add(2);
        assertThat(dinamic.get(2), is(2));
        dinamic.get(3);
    }

    @Test(expected = NoSuchElementException.class)
    public void thenTestsIterator() {
        DinamicArray<Integer> dinamic = new DinamicArray<>(new Integer[3]);
        dinamic.add(0);
        dinamic.add(1);
        dinamic.add(2);
        Iterator<Integer> iterator = dinamic.iterator();
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(0));
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(1));
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(2));
        MatcherAssert.assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }
    @Test(expected = ConcurrentModificationException.class)
    public void thenModifyArray() {
        DinamicArray<Integer> dinamic = new DinamicArray<>(new Integer[3]);
        dinamic.add(0);
        dinamic.add(1);
        dinamic.add(2);
        Iterator<Integer> iterator = dinamic.iterator();
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(0));
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(1));
        MatcherAssert.assertThat(iterator.hasNext(), is(true));
        MatcherAssert.assertThat(iterator.next(), is(2));
        MatcherAssert.assertThat(iterator.hasNext(), is(false));
        dinamic.add(3);
        iterator.next();
    }
}