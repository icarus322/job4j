package ru.job4j.list;

public class SimpleArrayList<E> {

    private int size;
    private Node<E> first;

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    public E delete() {
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

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public int getSize() {
        return this.size;
    }

    public Node<E> getFirst() {
        return first;
    }

    private static class Node<E> {

        E data;
        Node<E> next;

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
