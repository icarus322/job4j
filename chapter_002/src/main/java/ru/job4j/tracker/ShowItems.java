package ru.job4j.tracker;

public class ShowItems extends BaseAction {

    public ShowItems(int key, String name) {
        super(key, name);
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
}
