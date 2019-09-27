package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

      public void put(Task task) {
          var position = tasks.size();
          for (var i = 0; i < tasks.size(); i++) {
              if (task.getPriority() < tasks.get(i).getPriority()) {
                  position = i;
                  break;
              }
          }
          this.tasks.add(position, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}