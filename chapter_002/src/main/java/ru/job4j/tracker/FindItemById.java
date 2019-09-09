package ru.job4j.tracker;

import java.util.function.Consumer;

public class FindItemById extends BaseAction {

    public FindItemById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        String idAnswer = input.ask("Укажите id заявки");
        if (tracker.findById(idAnswer) != (null)) {
            output.accept("Ваша заявка: " + tracker.findById(idAnswer).getName());
        } else {
            output.accept("Такой заявки не существует");
        }
    }
}
