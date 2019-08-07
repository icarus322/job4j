package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {

    private List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    private int position = 0;

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        this.position++;
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
            if (this.items.get(i).getId().equals(id)) {
                this.items.set(i, item);
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.remove(i);
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    public List<Item> findAll() {
        return this.items;
    }

    public List<Item> findByName(String key) {
        List<Item> temp = new ArrayList<>();
        for (Item item : this.items) {
            if (item.getName().equals(key)) {
                temp.add(item);
            }
        }
        return temp;
    }

    public int getPosition() {
        return this.position;
    }

    public List<Item> getItems() {
        return this.items;
    }
}
