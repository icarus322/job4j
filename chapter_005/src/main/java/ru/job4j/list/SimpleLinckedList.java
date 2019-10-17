package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinckedList<E> implements Iterable<E> {

    private int size;
    private SimpleLinckedList.Node<E> first;
    private int modCount = 0;

    public void add(E model) {
        Node<E> newLink = new Node<>(model);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        this.modCount++;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public E deleteLast() {
        if (this.size <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<E> result = this.first.next;
        var temp = this.first.data;
        this.first = null;
        this.first = result;
        this.size--;
        return temp;
    }

    public int getSize() {
        return this.size;
    }

    public Node<E> getFirst() {
        return first;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int nextCounter = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return nextCounter < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(nextCounter++);
            }
        };
    }

    private static class Node<E> {

        E data;
        SimpleLinckedList.Node<E> next;

        Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
