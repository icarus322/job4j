package ru.job4j.tracker;

import java.util.function.Consumer;

public class StartUI {

    private final Input input;

    private final Tracker tracker;

    private final Consumer<String> output;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основой цикл программы.
     */

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        menu.fillActions();
        final int[] test = menu.getTest();
        do {
            menu.show();
            menu.select(input.ask("select:", test));
        } while (!"6".equals(this.input.ask("Exit?(6): ")));
    }


    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker(), System.out::println
        ).init();
    }
}
