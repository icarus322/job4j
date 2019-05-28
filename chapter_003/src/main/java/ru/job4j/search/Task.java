package ru.job4j.search;

public class Task implements Comparable<Task> {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task task) {
        return this.priority - task.priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}