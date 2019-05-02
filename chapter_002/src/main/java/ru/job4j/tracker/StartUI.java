package ru.job4j.tracker;

import java.util.Arrays;

public class StartUI extends Tracker {

    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_ID = "4";
    private static final String FIND_NAME = "5";
    private static final String EXIT = "6";
    private static final String YES = "yes";
    private static final String NO = "no";
    private static final String BACK = "back";

    private final Input input;

    private final Tracker tracker;
    private int count = 0;

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
                this.count++; //не смог понять почему getPosition всегда ноль.
            }
            else if (SHOW.equals(answer)) {
                this.showAllItem();
            }
            else if (EDIT.equals(answer)) {
                this.editItem();
            }
            else if (DELETE.equals(answer)) {
                this.deleteItem();
            }
            else if (FIND_ID.equals(answer)) {
                findId();
            }
            else if (FIND_NAME.equals(answer)) {
                findName();
            }
            else if (EXIT.equals(answer)) {
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
        System.out.println(getPosition());
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    private void showAllItem(){
        Item[] items = tracker.getItems();
        System.out.println("------------ Список заявок --------------");
        for (int i = 0; i < count ; i++) {
            System.out.println("Это " + (i + 1) + " заявка.");
            System.out.println("Имя:" + items[i].getName() + " Описание:" + items[i].getDecs() + " id заявки:" + items[i].getId());
            System.out.println(items[i].getId());
        }
        System.out.println("------------ Конец списка заявок --------------");
    }

    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        Item[] items = tracker.getItems();
        for (int i = 0; i < count; i++) {
            System.out.println(items[i].getName());
            String editAnswer = this.input.ask("Эту заявку нужно отредактировать (yes/no)? Для возврата в меню введи back.");
            if (YES.equals(editAnswer)){
                String name = this.input.ask("Введите новое имя заявки :");
                String desc = this.input.ask("Введите новое описание заявки :");
                long time = System.currentTimeMillis();
                Item item = new Item(name, desc, time);
                this.tracker.replace(items[i].getId(), item);
                System.out.println("------------ Отредактированная заявка с getId : " + item.getId() + "-----------");
            } else if (NO.equals(editAnswer)) {
                continue;
            } else if (BACK.equals(editAnswer)){
                break;
            }
        }
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        Item[] items = tracker.getItems();
        for (int i = 0; i < count; i++) {
            System.out.println(items[i].getName());
            String editAnswer = this.input.ask("Эту заявку нужно удалить (yes/no)? Для возврата в меню введи back.");
            if (YES.equals(editAnswer)){
                delete(items[i].getId()); // Не работает. Возможно причина в том же, почему и position не работает.
                System.out.println(items[i].getId());
                System.out.println("------------ Заявка удалена -----------");
                count--;
            }
            else if (NO.equals(editAnswer)) {
                continue;
            }
            else if (BACK.equals(editAnswer)){
                break;
            }
        }
    }

    private void findId(){
        String idAnswer = this.input.ask("Укажите id заявки");
        if(tracker.findById(idAnswer) != (null)) {
            System.out.println("Ваша заявка: " + tracker.findById(idAnswer).getName());
        } else {
            System.out.println("Такой заявки не существует");
        }
    }

    private void findName(){
        String nameAnswer = this.input.ask("Введи имя указанное в заявке");
        Item[] items = tracker.findByName(nameAnswer);
        System.out.println("------------ Список заявок c именем: " + nameAnswer + " --------------");
        for (int i = 0; i < getPosition(); i++) { // Если использовать count падает с аут оф баунс, с position так и не разобрался, прошу помочь.
            System.out.println("Это " + (i + 1) + " заявка.");
            System.out.println("Имя:" + items[i].getName() + " Описание:" + items[i].getDecs() + " id заявки:" + items[i].getId());
        }
        System.out.println("------------ Конец списка заявок --------------");
        //  System.out.println("------------ Заявок c именем: " + nameAnswer + " не существует --------------");
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

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
