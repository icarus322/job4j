package ru.job4j.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {

    @Test
    public void ThenScoreFrom70To100() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(6, "Tom"));
        students.add(new Student(-50, "Tom"));
        students.add(new Student(45, "Tom"));
        students.add(new Student(58, "Tom"));
        students.add(new Student(87, "Tom"));
        Predicate<Student> predicate = x -> x.getScore() >= 70 && x.getScore() <= 100;
        List<Student> result = new ArrayList<>();
        result.add(new Student(87, "Tom"));
        assertThat(school.collect(students, predicate), is(result));
    }

    @Test
    public void ThenScoreFrom50To69() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(6, "Tom"));
        students.add(new Student(-50, "Tom"));
        students.add(new Student(45, "Tom"));
        students.add(new Student(58, "Tom"));
        students.add(new Student(87, "Tom"));
        Predicate<Student> predicate = x -> x.getScore() >= 50 && x.getScore() <= 69;
        List<Student> result = new ArrayList<>();
        result.add(new Student(58, "Tom"));
        assertThat(school.collect(students, predicate), is(result));
    }

    @Test
    public void ThenScoreFromOneTo49() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(6, "Tom"));
        students.add(new Student(-50, "Tom"));
        students.add(new Student(45, "Tom"));
        students.add(new Student(58, "Tom"));
        students.add(new Student(87, "Tom"));
        Predicate<Student> predicate = x -> x.getScore() >= 1 && x.getScore() <= 49;
        List<Student> result = new ArrayList<>();
        result.add(new Student(6, "Tom"));
        result.add(new Student(45, "Tom"));
        assertThat(school.collect(students, predicate), is(result));
    }

    @Test
    public void ThenListStudentsToMap() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(50, "Alex"));
        students.add(new Student(37, "Kim"));
        students.add(new Student(79, "Zigs"));
        Map<String, Integer> result = new HashMap<>();
        result.put("Alex", 50);
        result.put("Kim", 37);
        result.put("Zigs", 79);
        assertThat(school.mapping(students), is(result));
    }
}
