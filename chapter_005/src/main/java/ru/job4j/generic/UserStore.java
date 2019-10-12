package ru.job4j.generic;


import java.util.Iterator;

public class UserStore implements Store<User>{

    SimpleArray<User> array;

    public UserStore(User[] users) {
        array = new SimpleArray<>(users);
    }


    @Override
    public void add(User model) {
        array.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        array.set(findId(id), model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        array.remove(findId(id));
        return true;
    }

    @Override
    public User findById(String id) {
        return array.get(findId(id));
    }

    public int findId(String id) {
        int counter = 0;
        int check = 0;
        Iterator<User> it = this.array.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)){
                check = 1;
                break;
            }
            counter++;
        }
        if (!it.hasNext() && check != 1) {
            throw new ArrayIndexOutOfBoundsException("Такого индекса не существует");
        }

        return counter;
    }

    public SimpleArray<User> getArray() {
        return array;
    }
}
