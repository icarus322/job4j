package ru.job4j.sorting;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int minLength = Math.min(left.length(), right.length());
        for (int i = 0; i < minLength; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
            if (i == minLength - 1) {
                result = left.length() - right.length();
            }
        }
        return result;
    }
}
