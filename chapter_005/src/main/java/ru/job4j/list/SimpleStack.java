package ru.job4j.list;

public class SimpleStack<T> {

    SimpleLinckedList<T> list = new SimpleLinckedList<>();

    public T poll() {
        return list.deleteLast();
    }

    public void push(T value) {
        list.add(value);
    }

    public T getFirst() {
        return list.getFirst();
    }

}
