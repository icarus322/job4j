package ru.job4j.iterators;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FirstIteratorTest {

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        FirstIterator firstIterator = new FirstIterator(new int[][]{{1}, {3, 4}, {7}});
        assertThat(firstIterator.next(), is(1));
        assertThat(firstIterator.next(), is(3));
        assertThat(firstIterator.next(), is(4));
        assertThat(firstIterator.next(), is(7));
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        FirstIterator firstIterator = new FirstIterator(new int[][]{{1}, {3, 4}, {7}});
        assertThat(firstIterator.hasNext(), is(true));
        assertThat(firstIterator.hasNext(), is(true));
        assertThat(firstIterator.next(), is(1));
        assertThat(firstIterator.next(), is(3));
        assertThat(firstIterator.next(), is(4));
        assertThat(firstIterator.next(), is(7));
    }

    @Test
    public void hasNextNextSequentialInvocation() {
        FirstIterator firstIterator = new FirstIterator(new int[][]{{1}, {3, 4}, {7}});
        assertThat(firstIterator.hasNext(), is(true));
        assertThat(firstIterator.next(), is(1));
        assertThat(firstIterator.hasNext(), is(true));
        assertThat(firstIterator.next(), is(3));
        assertThat(firstIterator.hasNext(), is(true));
        assertThat(firstIterator.next(), is(4));
        assertThat(firstIterator.hasNext(), is(true));
        assertThat(firstIterator.next(), is(7));
        assertThat(firstIterator.hasNext(), is(false));
    }
}
