package ru.job4j.array;

import java.util.Arrays;

public class Merge {
    public int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int size = left.length + right.length;
        int leftLength = left.length;
        int rightLength = right.length;
        if (leftLength == 0) {
            left = Arrays.copyOf(left, 1);
            left[0] = 999999999;
        }
        if (rightLength == 0) {
            right = Arrays.copyOf(right, 1);
            right[0] = 999999999;
        }
        for (int i = 0; i < size; i++) {
            int minLeft = left[0];
            int minRight = right[0];
            int deleteLeft = 0;
            int deleteRight = 0;
            int tmpLeft;
            int tmpRight;
            for (int loopLeft = 0; loopLeft < leftLength; loopLeft++) {
                if (left[0] > left[loopLeft] && left[loopLeft] < minLeft) {
                    minLeft = left[loopLeft];
                    deleteLeft = loopLeft;
                }
            }
            for (int loopRight = 0; loopRight < rightLength; loopRight++) {
                if (right[0] > right[loopRight] && right[loopRight] < minRight) {
                    minRight = right[loopRight];
                    deleteRight = loopRight;
                }
            }
            if (minLeft <= minRight) {
                rsl[i] = minLeft;
                tmpLeft = left[deleteLeft];
                left[deleteLeft] = left[leftLength - 1];
                left[leftLength - 1] = tmpLeft;
                left = Arrays.copyOf(left, leftLength - 1);
                leftLength--;
                if (leftLength == 0) {
                    left = Arrays.copyOf(left, 1);
                    left[0] = 999999999;
                }
            } else {
                rsl[i] = minRight;
                tmpRight = right[deleteRight];
                right[deleteRight] = right[rightLength - 1];
                right[rightLength - 1] = tmpRight;
                right = Arrays.copyOf(right, rightLength - 1);
                rightLength--;
                if (rightLength == 0) {
                    right = Arrays.copyOf(right, 1);
                    right[0] = 999999999;
                }
            }
        }
        return rsl;
    }
}
