package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class StubInputTest {

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.getItems()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerHasDeletedValue() {
        Tracker tracker = new Tracker();
        Item[] items = {
                tracker.add(new Item("first", "desc", System.currentTimeMillis())),
                tracker.add(new Item("third", "desc", System.currentTimeMillis())),
                tracker.add(new Item("second", "desc", System.currentTimeMillis()))
        };
        Item[] result = new Item[] {items[0], items[2]};
        Input input = new StubInput(new String[]{"3", items[1].getId(), "1", "6"});
        new StartUI(input, tracker).init();
        System.out.println(items[0].getId());
        System.out.println(items[1].getId());
        System.out.println(items[2].getId());
        assertThat(result, is(items));
    }
}
