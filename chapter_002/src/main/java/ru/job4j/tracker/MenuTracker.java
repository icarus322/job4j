package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuTracker {

    private Input input;

    private Tracker tracker;

    private List<UserAction> actions = new ArrayList<>();

    private int[] test = new int[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new UpdateItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public int[] getTest() {
        int[] test = new int[this.actions.size()];
        for (int i = 0; i < test.length; i++) {
            test[i] = actions.get(i).key();
        }
        return test;
    }
}