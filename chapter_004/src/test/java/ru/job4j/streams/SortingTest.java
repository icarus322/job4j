package ru.job4j.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortingTest {

    @Test
    public void WhenScoreHigher60() {
        Sorting sorting = new Sorting();
        List<Student> temp = new ArrayList<>();
        temp.add(new Student(10, "A"));
        temp.add(new Student(50, "B"));
        temp.add(new Student(70, "C"));
        temp.add(new Student(90, "D"));
        temp.add(new Student());
        List<Student> result = sorting.levelOf(temp, 60);
        List<Student> expect = new ArrayList<>();
        expect.add(new Student(90, "D"));
        expect.add(new Student(70, "C"));
        assertThat(result, is(expect));
    }

    @Test
    public void WhenScoreHigher20() {
        Sorting sorting = new Sorting();
        List<Student> temp = new ArrayList<>();
        temp.add(new Student(10, "A"));
        temp.add(new Student(50, "B"));
        temp.add(new Student(70, "C"));
        temp.add(new Student(90, "D"));
        temp.add(new Student());
        List<Student> result = sorting.levelOf(temp, 20);
        List<Student> expect = new ArrayList<>();
        expect.add(new Student(90, "D"));
        expect.add(new Student(70, "C"));
        expect.add(new Student(50, "B"));
        assertThat(result, is(expect));
    }
}
