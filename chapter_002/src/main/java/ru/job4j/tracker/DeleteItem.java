package ru.job4j.tracker;

import java.util.function.Consumer;

public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("------------ Удаление заявки --------------");
        String editAnswer = input.ask("Укажите id заявки, которую нужно удалить.");
        if (tracker.delete(editAnswer)) {
            output.accept("------------ Заявка удалена -----------");
        } else {
            output.accept("------------ Заявки с таким id не существует -----------");
        }
    }
}
