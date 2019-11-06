package ru.job4j.generic;

import java.util.Iterator;

public class AbstractStore<T extends Base> implements Store<T> {

    SimpleArray<T> array;

    public AbstractStore(T[] base) {
        array = new SimpleArray<>(base);
    }


    @Override
    public void add(T model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result;
        int temp = findId(id);
        if (temp == -1) {
            result = false;
        } else {
            array.set(temp, model);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result;
        int temp = findId(id);
        if (temp == -1) {
            result = false;
        } else {
            array.remove(temp);
            result = true;
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result;
        int temp = findId(id);
        if (temp == -1) {
            result = null;
        } else {
            result = array.get(temp);
        }
        return result;
    }

    public int findId(String id) {
        int counter = 0;
        int check = 0;
        Iterator<T> it = this.array.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)){
                check = 1;
                break;
            }
            counter++;
        }
        if (!it.hasNext() && check != 1) {
            counter = -1;
        }

        return counter;
    }

    public SimpleArray<T> getArray() {
        return array;
    }
}
