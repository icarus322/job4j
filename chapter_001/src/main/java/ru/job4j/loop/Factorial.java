package ru.job4j.loop;

public class Factorial {
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n ; i++) {
//            if (n == 0){
//                break;
//            } else {
                result = result * i;
//            }
        }
        return result;
    }
}