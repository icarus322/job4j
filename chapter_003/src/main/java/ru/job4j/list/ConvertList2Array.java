package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {

        int cells = list.size() / rows;
        if (list.size() % rows == 1) {
            cells++;
        }
        int tmpOut = 0;
        int tmpIn = 0;
        int[][] array = new int[rows][cells];

        for (int test : list) {
            array[tmpOut][tmpIn] = test;
            tmpIn++;
            if (tmpIn == rows) {
                tmpOut++;
                tmpIn = 0;
            }
        }

        return array;
    }
}