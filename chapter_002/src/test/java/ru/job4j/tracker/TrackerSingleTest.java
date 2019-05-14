package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleTest {

    @Test
    public void whenCreateFewTrackerSingle1ThenCreatesOneTracker() {
        TrackerSingle1 trackerSingleFirst = TrackerSingle1.INSTANSE;
        Item itemFirst = new Item("test1", "test1", 100);
        trackerSingleFirst.add(itemFirst);
        TrackerSingle1 trackerSingleSecond = TrackerSingle1.INSTANSE;
        Item itemSecond = new Item("test2", "test2", 200);
        trackerSingleSecond.add(itemSecond);
        assertThat(trackerSingleFirst, is(trackerSingleSecond));
    }

    @Test
    public void whenCreateFewTrackerSingle2ThenCreatesOneTracker() {
        TrackerSingle2 trackerSingleFirst = TrackerSingle2.getInstance();
        Item itemFirst = new Item("test1", "test1", 100);
        trackerSingleFirst.add(itemFirst);
        TrackerSingle2 trackerSingleSecond = TrackerSingle2.getInstance();
        Item itemSecond = new Item("test2", "test2", 200);
        trackerSingleSecond.add(itemSecond);
        assertThat(trackerSingleFirst, is(trackerSingleSecond));
    }

    @Test
    public void whenCreateFewTrackerSingle3ThenCreatesOneTracker() {
        TrackerSingle3 trackerSingleFirst = TrackerSingle3.getInstance();
        Item itemFirst = new Item("test1", "test1", 100);
        trackerSingleFirst.add(itemFirst);
        TrackerSingle3 trackerSingleSecond = TrackerSingle3.getInstance();
        Item itemSecond = new Item("test2", "test2", 200);
        trackerSingleSecond.add(itemSecond);
        assertThat(trackerSingleFirst, is(trackerSingleSecond));
    }

    @Test
    public void whenCreateFewTrackerSingle4ThenCreatesOneTracker() {
        TrackerSingle4 trackerSingleFirst = TrackerSingle4.getInstance();
        Item itemFirst = new Item("test1", "test1", 100);
        trackerSingleFirst.add(itemFirst);
        TrackerSingle4 trackerSingleSecond = TrackerSingle4.getInstance();
        Item itemSecond = new Item("test2", "test2", 200);
        trackerSingleSecond.add(itemSecond);
        assertThat(trackerSingleFirst, is(trackerSingleSecond));
    }


}
