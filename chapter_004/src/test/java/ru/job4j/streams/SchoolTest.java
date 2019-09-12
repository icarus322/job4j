package ru.job4j.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    @Test
    public void ThenScoreFrom70To100() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(6));
        students.add(new Student(-50));
        students.add(new Student(45));
        students.add(new Student(58));
        students.add(new Student(87));
        Predicate<Student> predicate = x -> x.getScore() >= 70 && x.getScore() <= 100;
        List<Student> result = new ArrayList<>();
        result.add(new Student(87));
        assertThat(school.collect(students, predicate), is(result));
    }

    @Test
    public void ThenScoreFrom50To69() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(6));
        students.add(new Student(-50));
        students.add(new Student(45));
        students.add(new Student(58));
        students.add(new Student(87));
        Predicate<Student> predicate = x -> x.getScore() >= 50 && x.getScore() <= 69;
        List<Student> result = new ArrayList<>();
        result.add(new Student(58));
        assertThat(school.collect(students, predicate), is(result));
    }

    @Test
    public void ThenScoreFromOneTo49() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(6));
        students.add(new Student(-50));
        students.add(new Student(45));
        students.add(new Student(58));
        students.add(new Student(87));
        Predicate<Student> predicate = x -> x.getScore() >= 1 && x.getScore() <= 49;
        List<Student> result = new ArrayList<>();
        result.add(new Student(6));
        result.add(new Student(45));
        assertThat(school.collect(students, predicate), is(result));
    }
}
