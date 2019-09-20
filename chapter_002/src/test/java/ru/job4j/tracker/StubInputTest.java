package ru.job4j.tracker;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class StubInputTest {
    private final PrintStream out = System.out;
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker, this.output).init();
        assertThat(tracker.getItems().get(0).getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker, this.output).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        Tracker tracker = new Tracker();
        List<Item> items = new ArrayList<>();
        items.add(tracker.add(new Item("first", "desc", System.currentTimeMillis())));
        items.add(tracker.add(new Item("third", "desc", System.currentTimeMillis())));
        items.add(tracker.add(new Item("second", "desc", System.currentTimeMillis())));
        List<Item> result = new ArrayList<>();
        result.add(items.get(0));
        result.add(items.get(2));
        Input input = new StubInput(new String[]{"3", items.get(1).getId(), "6"});
        new StartUI(input, tracker, this.output).init();
        assertThat(tracker.findAll(), is(result));
    }
}
