package ru.job4j.iterators;

import java.util.Iterator;

public class FirstIterator implements Iterator {

    private final int[][] values;
    private int indexIn = 0;
    private int indexOut = 0;

    public FirstIterator(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        boolean result = true;
        if (indexOut == this.values.length - 1) {
            if (indexIn != this.values[indexOut].length - 1) {
                result = false;
            }
        }
        return result;
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
        return result;
    }
}
