package ru.job4j.tracker;

public class FindItemById extends BaseAction {

    public FindItemById(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String idAnswer = input.ask("Укажите id заявки");
        if (tracker.findById(idAnswer) != (null)) {
            System.out.println("Ваша заявка: " + tracker.findById(idAnswer).getName());
        } else {
            System.out.println("Такой заявки не существует");
        }
    }
}
