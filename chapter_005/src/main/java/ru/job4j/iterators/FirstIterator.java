package ru.job4j.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

public class FirstIterator implements Iterator {

    private final int[][] values;
    private int indexIn = 0;
    private int indexOut = 0;
    private int counter = 0;

    public FirstIterator(final int[][] values) {
        this.values = values;
    }

    public int getElementCount() {
        long temp = (Stream.of(values)
                .flatMapToInt(Arrays::stream)
                .count());
        return Math.toIntExact(temp);
    }

    @Override
    public boolean hasNext() {
        return counter < getElementCount();
    }

    @Override
    public Object next() {
        int result;
        if (indexIn < values[indexOut].length) {
            result = values[indexOut][indexIn++];
        } else {
            indexOut++;
            result = values[indexOut][0];
            indexIn = 1;
        }
        counter++;
        return result;
    }
}
