package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

      public void put(Task task) {
          for (int i = 0; i <= tasks.size(); i++) {
              if (i == 0) {
                  this.tasks.add(task);
              }
              if (task.getPriority() < tasks.get(i).getPriority()) {
                  this.tasks.add(i, task);
                  break;
              } else if (i >= tasks.size() - 1) {
                  this.tasks.add(i, task);
                  break;
              }
          }
    }

    public Task take() {
        return this.tasks.poll();
    }
}