package ru.job4j.list;

public class SimpleStack<T> {

    private SimpleLinckedList<T> list = new SimpleLinckedList<>();

    public T poll() {
        return list.deleteLast();
    }

    public void push(T value) {
        list.add(value);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}
