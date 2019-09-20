package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

public class ShowItems extends BaseAction {

    public ShowItems(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        List<Item> items = tracker.getItems();
        output.accept("------------ Список заявок --------------");
        output.accept("Номер");
        for (int i = 0; i < tracker.getPosition(); i++) {
            System.out.printf("№ %2d    Имя: %s, описание: %s, id заявки: %s", (i + 1), items.get(i).getName(), items.get(i).getDecs(), items.get(i).getId());
        }
        output.accept("------------ Конец списка заявок --------------");
    }
}
