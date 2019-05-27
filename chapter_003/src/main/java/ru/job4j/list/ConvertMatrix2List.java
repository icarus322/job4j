package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        int lengthOut = array.length;
        int lengthIn = array[0].length;

        for (int i = 0; i < lengthOut; i++) {
            for (int j = 0; j < lengthIn; j++) {
                list.add(array[i][j]);
            }
        }

        return list;
    }
}
