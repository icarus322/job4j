package ru.job4j.list;

public class SimpleStack<T> {

    private int size;
    private Node<T> first;

    public T poll() {
        if (this.size <= 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node<T> result = this.first.next;
        var temp = this.first.data;
        this.first = null;
        this.first = result;
        this.size--;
        return temp;
    }

    public void push(T value) {
        Node<T> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    public T getFirst() {
        return first.data;
    }

    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
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
