package ru.job4j.tracker;


import java.util.List;
import java.util.function.Consumer;

public class FindItemsByName extends BaseAction {

    public FindItemsByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        String nameAnswer = input.ask("Введи имя указанное в заявке");
        List<Item> items = tracker.findByName(nameAnswer);
        output.accept("------------ Список заявок c именем: " + nameAnswer + " --------------");
        for (int i = 0; i < items.size(); i++) {
            output.accept("Это " + (i + 1) + " заявка.");
            System.out.printf("Имя: %s, описание: %s, id заявки:%s", items.get(i).getName(), items.get(i).getDecs(), items.get(i).getId());
        }
        output.accept("------------ Конец списка заявок --------------");
    }
}
