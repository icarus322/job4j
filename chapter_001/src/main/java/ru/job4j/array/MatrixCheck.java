package ru.job4j.array;

public class MatrixCheck {
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int length = data.length - 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (data[i][j] == data[i + 1][j + 1]) {
                    i = i + 1;
                    j = j + 1;
                } else {
                    result = false;
                    break;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = length; j > 0; j--) {
                if (data[i][j] == data[i + 1][j - 1]) {
                    i = i + 1;
                    j = j - 1;
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}