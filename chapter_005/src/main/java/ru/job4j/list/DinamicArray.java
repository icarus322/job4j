package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicArray<T> implements Iterable<T> {

    private T[] array;
    private int addCounter = 0;
    private int modCount = 0;

    public DinamicArray(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    private void arrayGrow() {
        this.array = Arrays.copyOf(this.array, addCounter * 2);
    }

    public void add(T model) {
        if (addCounter == array.length) {
            arrayGrow();
        }
        this.array[addCounter++] = model;
        modCount++;
    }

    public T get(int index) {
        if (index >= addCounter) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int nextCounter = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return nextCounter < addCounter;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(nextCounter++);
            }
        };
    }
}
