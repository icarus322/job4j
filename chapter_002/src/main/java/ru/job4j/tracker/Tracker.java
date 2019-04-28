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
            if (item.getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        Item[] tmp = Arrays.copyOf(this.items, this.position);
        for (int i = 0; i < this.position; i++) {
            if (tmp[i].getId().equals(id)) {
                if (i == this.position - 1) {
                    result = true;
                    break;
                }
                System.arraycopy(tmp, i + 1, this.items, i, position - 1);
                this.items = Arrays.copyOf(this.items, this.position - 1);
            }
        }
        return result;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        int number = 0;
        Item[] tmp = Arrays.copyOf(this.items, this.position);
        for (int i = 0; i < this.position; i++) {
            if (tmp[i].getName().equals(key)) {
                tmp[number] = tmp[i];
                tmp[number].setName(key);
                number++;
            }
            if (i == this.position - 1 && number > 0) {
                tmp = Arrays.copyOf(tmp, number);
                break;
            }
        }
        return tmp;
    }




}
