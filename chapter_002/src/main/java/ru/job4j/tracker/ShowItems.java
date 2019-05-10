package ru.job4j.tracker;

public class ShowItems implements UserAction {

    @Override
    public int key() {
        return 1;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] items = tracker.getItems();
        System.out.println("------------ Список заявок --------------");
        System.out.println("Номер");
        for (int i = 0; i < tracker.getPosition(); i++) {
            System.out.printf("№ %2d    Имя: %s, описание: %s, id заявки: %s", (i + 1), items[i].getName(), items[i].getDecs(), items[i].getId());
            System.out.println();
        }
        System.out.println("------------ Конец списка заявок --------------");
    }

    @Override
    public String info() {
        return "1. Show Items.";
    }
}
