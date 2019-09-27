package ru.job4j.streams;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sorting {

    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted()
                .filter(Objects::nonNull)
                .takeWhile(x -> x.getScore() > bound)
                .collect(Collectors.toList());
    }
}
