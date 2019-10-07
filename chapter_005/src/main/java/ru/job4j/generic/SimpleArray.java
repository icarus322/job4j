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
        try {
            this.array[addCounter++] = model;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    public void set(int index, T model) {
        try {
            this.array[index] = model;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    public T get(int index) {
        try {
            return this.array[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(int index) {
        try {
            this.array[index] = null;
            for (int i = 0; i < this.array.length - 1; i++) {
                if (this.array[i] == null && this.array[i + 1] != null) {
                    var tmp = this.array[i];
                    this.array[i] = this.array[i + 1];
                    this.array[i + 1] = tmp;
                }
            }
            addCounter--;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>(){

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
