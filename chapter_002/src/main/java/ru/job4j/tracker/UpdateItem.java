package ru.job4j.tracker;

public class UpdateItem extends BaseAction {

    public UpdateItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактирование заявки --------------");
        String editAnswer = input.ask("Укажите id заявки, которую нужно отредактировать.");
        String name = input.ask("Введите новое имя заявки :");
        String desc = input.ask("Введите новое описание заявки :");
        long time = System.currentTimeMillis();
        Item item = new Item(name, desc, time);
        if (tracker.replace(editAnswer, item)) {
            tracker.replace(editAnswer, item);
            System.out.println("------------ Отредактированная заявка с id: " + item.getId() + "-----------");
        } else {
            System.out.println("------------ Заявки с таким id не существует -----------");
        }
    }
}
