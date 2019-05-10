package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class StartUI {

    private final Input input;

    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        int[] test = new int[0];
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
            test = Arrays.copyOf(test, i + 1);
            test[i] = i;
        }
        do {
            menu.show();
            menu.select(input.ask("select:", test));
        } while (!"6".equals(this.input.ask("Exit?(6): ")));
    }


    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
