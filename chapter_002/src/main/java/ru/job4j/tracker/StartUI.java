package ru.job4j.tracker;


public class StartUI {

    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_ID = "4";
    private static final String FIND_NAME = "5";
    private static final String EXIT = "6";

    private final Input input;

    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAllItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_ID.equals(answer)) {
                this.findId();
            } else if (FIND_NAME.equals(answer)) {
                this.findName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        long time = System.currentTimeMillis();
        Item item = new Item(name, desc, time);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showAllItem() {
        Item[] items = tracker.getItems();
        System.out.println("------------ Список заявок --------------");
        System.out.println("Номер");
        for (int i = 0; i < this.tracker.getPosition(); i++) {
            System.out.printf("№ %2d    Имя: %s, описание: %s, id заявки:%s", (i + 1), items[i].getName(), items[i].getDecs(), items[i].getId());
            System.out.println(items[i].getId());
        }
        System.out.println("------------ Конец списка заявок --------------");
    }


    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        Item[] items = this.tracker.getItems();
        showAllItem();
        System.out.println("Укажите номер заявки, которую нужно отредактировать.");
        int editAnswer = this.input.askInt(0);
        if (editAnswer <= this.tracker.getPosition()) {
            String name = this.input.ask("Введите новое имя заявки :");
            String desc = this.input.ask("Введите новое описание заявки :");
            long time = System.currentTimeMillis();
            Item item = new Item(name, desc, time);
            this.tracker.replace(items[editAnswer - 1].getId(), item);
            System.out.println("------------ Отредактированная заявка с getId : " + item.getId() + "-----------");
        } else {
            System.out.println("------------ Заявки с таким номером не существует -----------");
        }
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        Item[] items = this.tracker.getItems();
        showAllItem();
        System.out.println("Укажите номер заявки, которую нужно удалить.");
        int editAnswer = this.input.askInt(0);
        if (editAnswer <= this.tracker.getPosition()) {
            this.tracker.delete(items[editAnswer - 1].getId());
            System.out.println("------------ Заявка удалена -----------");
        } else {
            System.out.println("------------ Заявки с таким номером не существует -----------");
        }
    }

    private void findId() {
        String idAnswer = this.input.ask("Укажите id заявки");
        if (tracker.findById(idAnswer) != (null)) {
            System.out.println("Ваша заявка: " + tracker.findById(idAnswer).getName());
        } else {
            System.out.println("Такой заявки не существует");
        }
    }

    private void findName() {
        String nameAnswer = this.input.ask("Введи имя указанное в заявке");
        Item[] items = tracker.findByName(nameAnswer);
        System.out.println("------------ Список заявок c именем: " + nameAnswer + " --------------");
        for (int i = 0; i < items.length; i++) {
            System.out.println("Это " + (i + 1) + " заявка.");
            System.out.printf("Имя: %s, описание: %s, id заявки:%s", items[i].getName(), items[i].getDecs(), items[i].getId());
        }
        System.out.println("------------ Конец списка заявок --------------");
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
