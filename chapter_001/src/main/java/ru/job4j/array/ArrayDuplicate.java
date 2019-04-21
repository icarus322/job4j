package ru.job4j.array;


import java.util.Arrays;

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        for (int i = 0; i < array.length; i++) {
            String remover = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (remover.equals(array[j])) {
                    String tmp = array[j];
                    array[j] = array[array.length - 1];
                    array[array.length - 1] = tmp;
                    array = Arrays.copyOf(array, array.length - 1);
                }
            }
        }
        return array;
    }
}
