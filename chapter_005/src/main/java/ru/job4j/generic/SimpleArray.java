package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private T[] array;
    private int addCounter = 0;
    private int nextCounter = 0;

    public SimpleArray(T[] models) {
        array = models;
    }

    public T[] getArray() {
        return array;
    }

    public void add(T model) {
        if (addCounter >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.array[addCounter++] = model;
    }

    public void set(int index, T model) {
        if (index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.array[index] = model;
    }

    public T get(int index) {
        if (index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.array[index];
    }

    public void remove(int index) {
        if (index >= array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.array[index] = null;
        for (int i = 0; i < this.array.length - 1; i++) {
            if (this.array[i] == null && this.array[i + 1] != null) {
                var tmp = this.array[i];
                this.array[i] = this.array[i + 1];
                this.array[i + 1] = tmp;
            }
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                return nextCounter < addCounter;
            }

            @Override
            public T next() {
                if (nextCounter >= addCounter) {
                    throw new NoSuchElementException();
                }
                return get(nextCounter++);

            }
        };
    }
}
