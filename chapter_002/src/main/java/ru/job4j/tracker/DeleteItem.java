package ru.job4j.tracker;

public class DeleteItem extends BaseAction {

    public DeleteItem(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удаление заявки --------------");
        String editAnswer = input.ask("Укажите id заявки, которую нужно удалить.");
        if (tracker.delete(editAnswer)) {
            System.out.println("------------ Заявка удалена -----------");
        } else {
            System.out.println("------------ Заявки с таким id не существует -----------");
        }
    }
}
