package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if(list.size() % rows == 1) {
            cells++;
        }
        int pos = 0;
        int[][] array = new int[rows][cells];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if(pos == list.size()){
                    break;
                }
                array[i][j] = list.get(pos);
                pos++;
            }
        }
        return array;
    }
}