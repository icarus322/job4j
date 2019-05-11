package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            boolean invalid = true;
            int value = -1;
            do {
                try {
                    value = ask(question, range);
                    invalid = false;
                } catch (MenuOutException moe) {
                    System.out.println("Please select key from menu ");
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter validate data again ");
                }
            } while (invalid);
            return  value;
        }

    }

}
