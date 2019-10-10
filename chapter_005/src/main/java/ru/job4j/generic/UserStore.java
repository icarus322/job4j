package ru.job4j.generic;



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
        boolean result;
        try {
            array.set(Integer.valueOf(id), model);
            result = true;
        } catch (ArrayIndexOutOfBoundsException e) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result;
        try {
            array.remove(Integer.valueOf(id));
            result = true;
        } catch (ArrayIndexOutOfBoundsException e) {
            result = false;
        }
        return result;
    }

    @Override
    public User findById(String id) {
        return array.get(Integer.valueOf(id));
    }

    public SimpleArray<User> getArray() {
        return array;
    }
}
