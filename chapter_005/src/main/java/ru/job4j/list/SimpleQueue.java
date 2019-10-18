package ru.job4j.list;

public class SimpleQueue<T> {

    private SimpleStack<T> inbox = new SimpleStack<>();
    private SimpleStack<T> outbox = new SimpleStack<>();

    public void push(T value) {
        inbox.push(value);
    }

    public T poll() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.poll());
            }
        }
        return outbox.poll();
    }

    public T getFirst() {
        return inbox.getFirst();
    }
}
