package ru.job4j.list;

public class LoopFinder {

    Node<Integer> first = new Node<>(1);
    Node<Integer> two = new Node<>(2);
    Node<Integer> third = new Node<>(3);
    Node<Integer> four = new Node<>(4);

    public void start() {
        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
    }

    public boolean hasCycle(Node root) {
        boolean result = true;
        if (root == null) {
            result = false;
        }
        Node tortoise = root;
        Node hare = root;

        while (result) {
            tortoise = tortoise.next;

            if (hare.next != null) {
                hare = hare.next.next;
            } else {
                result = false;
            }
            if ((tortoise == null) || (hare == null)) {
                result = false;
            }
            if (tortoise == hare) {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LoopFinder loopFinder = new LoopFinder();
        loopFinder.start();
        System.out.println(loopFinder.hasCycle(loopFinder.first));
        System.out.println(loopFinder.hasCycle(loopFinder.two));
        System.out.println(loopFinder.hasCycle(loopFinder.third));
        System.out.println(loopFinder.hasCycle(loopFinder.four));
    }

    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
