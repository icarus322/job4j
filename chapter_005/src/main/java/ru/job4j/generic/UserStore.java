package ru.job4j.generic;


import java.util.Iterator;

public class UserStore implements Store<User>{

    SimpleArray<User> array;

    public UserStore(User[] users) {
        array = new SimpleArray<>(users);
    }

    public int validateId(String id) {
        int result;
        try {
            result = Integer.valueOf(id);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Некорректное значение Id");
        }
        return result;
    }

    @Override
    public void add(User model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        if (findId(id) == -1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array.set(findId(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        if (findId(id) == -1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        array.remove(findId(id));
        return true;
    }

    @Override
    public User findById(String id) {
        if (findId(id) == -1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array.get(findId(id));
    }

    public int findId(String id) {
        int counter = 0;
        int check = 0;
        Iterator<User> it = this.array.iterator();
        while (it.hasNext()) {
            if (validateId(it.next().getId()) == validateId(id)){
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

    public SimpleArray<User> getArray() {
        return array;
    }
}
