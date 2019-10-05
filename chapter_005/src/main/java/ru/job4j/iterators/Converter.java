package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> iterator = it.next();
            public boolean checkNext() {
                if (!iterator.hasNext() && it.hasNext()) {
                    iterator = it.next();
                }
                return iterator.hasNext();

            }

            @Override
            public boolean hasNext() {
                return checkNext();
            }

            @Override
            public Integer next() {
                int result;
                if (checkNext()) {
                    result = iterator.next();
                } else {
                    throw new NoSuchElementException();
                }
                return result;
            }
        };
    }
}
