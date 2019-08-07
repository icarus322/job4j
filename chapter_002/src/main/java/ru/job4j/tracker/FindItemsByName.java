package ru.job4j.tracker;


import java.util.List;

public class FindItemsByName extends BaseAction {

    public FindItemsByName(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String nameAnswer = input.ask("Введи имя указанное в заявке");
        List<Item> items = tracker.findByName(nameAnswer);
        System.out.println("------------ Список заявок c именем: " + nameAnswer + " --------------");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("Это " + (i + 1) + " заявка.");
            System.out.printf("Имя: %s, описание: %s, id заявки:%s", items.get(i).getName(), items.get(i).getDecs(), items.get(i).getId());
        }
        System.out.println("------------ Конец списка заявок --------------");
    }
}
