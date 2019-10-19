package ru.job4j.list;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {

    DinamicArray<E> set;

    public SimpleSet(E[] list) {
        this.set = new DinamicArray<>(list);
    }

    public void add(E model) {
        boolean check = false;
        for (int i = 0; i < set.getSize(); i++) {
            if (model.equals(set.get(i))) {
                check = true;
                break;
            }
        }
        if (!check) {
            set.add(model);
        }
    }

    public E[] getArray() {
        return set.getArray();
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }
}
