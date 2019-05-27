package ru.job4j.search;

import java.util.Collections;
import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */

    public void put(Task task) {
        this.tasks.add(task);
        Collections.sort(tasks);

    }

    public Task take() {
        return this.tasks.poll();
    }
}