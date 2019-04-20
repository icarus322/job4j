package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
        int lengthArray = data.length;
        boolean tmp;
        for (int i = 0; i <= lengthArray; i++) {
            if (i == lengthArray) {
                break;
            }
            if (i == lengthArray - 1) {
                tmp = data[i];
            } else {
                tmp = data[i + 1];
            }
            if (data[i] != tmp) {
                result = false;
                break;
            } else {
                result = true;
            }
        }
        return result;
    }
}