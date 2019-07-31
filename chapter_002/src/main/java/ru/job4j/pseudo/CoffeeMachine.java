package ru.job4j.pseudo;

import java.util.Arrays;

public class CoffeeMachine {

    public static final int[] COINS = new int[]{10, 5, 2, 1};

    public int[] changes(int value, int price) {
        int[] result = new int[0];
        int change;
        if (check(value, price)) {
            change = value - price;
            int step;
            int counter = 0;
            int[] temp = new int[change];
            for (step = 0; change > 0;) {
                if (change >= COINS[step]) {
                    change = change - COINS[step];
                    temp[counter] = COINS[step];
                    counter++;
                } else {
                    step++;
                }
            }
            result = Arrays.copyOf(temp, counter);
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public boolean check(int value, int price) {
        boolean result = false;
        if (value == 50 || value == 100 || value == 500 || value == 1000) {
            if (value >= price) {
                result = true;
            } else {
                System.out.println("Вы не можете себе позволить этот напиток");
            }
        } else {
            System.out.println("Вставьте другую купюру");
        }
        return result;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.changes(50, 29);
    }
}
