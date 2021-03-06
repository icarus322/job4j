package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {

    private Input input;

    private Tracker tracker;

    private final Consumer<String> output;

    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void fillActions() {
        this.actions.add(new AddItem(0, "Add new Item."));
        this.actions.add(new ShowItems(1, "Show Items."));
        this.actions.add(new UpdateItem(2, "Update Item."));
        this.actions.add(new DeleteItem(3, "Delete Item."));
        this.actions.add(new FindItemById(4, "Find Item by ID."));
        this.actions.add(new FindItemsByName(5, "Find Item by name."));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker, this.output);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
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
