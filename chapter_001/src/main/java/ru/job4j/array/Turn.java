package ru.job4j.array;

public class Turn {
    public int[] back(int[] array) {
        int tmp;
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            tmp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = tmp;
        }
        return array;
    }
}
