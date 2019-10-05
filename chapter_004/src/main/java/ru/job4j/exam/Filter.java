package ru.job4j.exam;

import java.util.stream.Stream;

public class Filter {

    public Integer examFilter(Integer[] input) {
        return Stream.of(input)
                .filter(x -> x % 2 == 1)
                .map(x -> x * x)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
