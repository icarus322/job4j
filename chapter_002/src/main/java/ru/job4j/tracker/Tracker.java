package ru.job4j.tracker;

//import com.sun.tools.javac.jvm.Items;

import java.util.Arrays;
import java.util.Random;

public class Tracker {

    private Item[] items = new Item[100];
    private static final Random RN = new Random();

    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        item.setId(id);
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, position - 1 - i);
                items[position--] = null;
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        int number = 0;
        Item[] temp = new Item[this.position];
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                temp[number++] = this.items[i];
            }
        }
        return Arrays.copyOf(temp, number);
    }

    public int getPosition() {
        return this.position;
    }

    public Item[] getItems() {
        return this.items;
    }
}
