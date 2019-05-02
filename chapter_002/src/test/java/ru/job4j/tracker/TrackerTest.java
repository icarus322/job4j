package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenReplaceNameThenReturnNewName3() {
        Tracker tracker = new Tracker();
        Item first = new Item("first", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("second", "testDescription", 12344L);
        tracker.add(second);
        Item third = new Item("third", "testDescription2", 1234L);
        third.setId(first.getId());
        tracker.replace(first.getId(), third);
        assertThat(tracker.findById(first.getId()).getName(), is("third"));
    }

    @Test
    public void whenDeleteItemThenReturnNewArray() {
        Tracker tracker = new Tracker();
        Item first = new Item("first", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("second", "testDescription", 12344L);
        tracker.add(second);
        Item third = new Item("third", "testDescription2", 1234L);
        tracker.add(third);
        tracker.delete(first.getId());
        assertThat(tracker.findById(first.getId()), is(nullValue()));
    }

    @Test
    public void whenFindItemThenReturnAllButNull() {
        Tracker tracker = new Tracker();
        Item[] items = {
                tracker.add(new Item("first", "testDescription", 123L)),
                tracker.add(new Item("third", "testDescription2", 1234L)),
                tracker.add(new Item()),
                tracker.add(new Item())
        };
        tracker.findAll();
        assertThat(items, is(tracker.findAll()));
    }

    @Test
    public void whenFindByNameThenReturnOnlyName() {
        Tracker tracker = new Tracker();
        Item first = new Item("first", "testDescription", 123L);
        tracker.add(first);
        Item second = new Item("second", "testDescription", 12344L);
        tracker.add(second);
        Item third = new Item("first", "testDescription2", 1234L);
        tracker.add(third);
        Item[] expected = new Item[2];
        expected[0] = first;
        expected[1] = third;
        assertArrayEquals(expected, tracker.findByName("first"));
    }



}
