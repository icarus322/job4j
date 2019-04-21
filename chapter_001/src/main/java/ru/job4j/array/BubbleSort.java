package ru.job4j.array;

public class BubbleSort {
    public int[] sort(int[] array) {
        int tmp;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                length = length - 1;
                i = 0;
            }
            if (array[i] > array[i + 1]) {
                tmp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = tmp;
            }
        }
        return array;
    }
}
