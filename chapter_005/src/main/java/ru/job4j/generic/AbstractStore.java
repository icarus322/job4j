package ru.job4j.generic;

import java.util.Iterator;

public class AbstractStore implements Store<Base> {

    SimpleArray<Base> array;

    public AbstractStore(Base[] Bases) {
        array = new SimpleArray<>(Bases);
    }


    @Override
    public void add(Base model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
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
    public Base findById(String id) {
        Base result;
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
        Iterator<Base> it = this.array.iterator();
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

    public SimpleArray<Base> getArray() {
        return array;
    }
}
