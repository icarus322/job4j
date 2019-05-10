package ru.job4j.tracker;

public class FindItemById implements UserAction {

    @Override
    public int key() {
        return 4;
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

    @Override
    public String info() {
        return "4. Find Item by ID.";
    }
}
