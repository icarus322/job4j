package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {

    private final int[] numbers;
    private int counter;

    public EvenNumbersIterator(final int[] numbers) {
        this.numbers = numbers;
    }

    public boolean checkEven() {
        var result = false;
        for (; counter < this.numbers.length;) {
            if (this.numbers[counter] % 2 == 0) {
                result = true;
                break;
            } else {
                counter++;
            }
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return checkEven();
    }

    @Override
    public Object next() {
        if (!checkEven()) {
            throw new NoSuchElementException();
        }
        return this.numbers[counter++];
    }
}
