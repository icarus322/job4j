package ru.job4j.array;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort bubbleSorter = new BubbleSort();
        int[] input = new int[] {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = bubbleSorter.sort(input);
        int[] expect = new int[] {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, Matchers.is(expect));
    }
    @Test
    public void whenSortArrayWith5ElementsThenSortedArray() {
        BubbleSort bubbleSorter = new BubbleSort();
        int[] input = new int[] {1, 5, 4, 2, 3};
        int[] result = bubbleSorter.sort(input);
        int[] expect = new int[] {1, 2, 3, 4, 5};
        assertThat(result, Matchers.is(expect));
    }

}