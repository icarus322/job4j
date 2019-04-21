package ru.job4j.array;

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = true;
        int lengthArray = data.length;
        for (int i = 0; i < lengthArray; i++) {
            if (data[0] != data [i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}