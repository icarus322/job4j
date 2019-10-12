package ru.job4j.generic;


import java.util.Iterator;

public class UserStore implements Store<User>{

    AbstractStore abstr;

    public UserStore(User[] users) {
        abstr = new AbstractStore(users);;
    }


    @Override
    public void add(User model) {
        abstr.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        return abstr.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return abstr.delete(id);
    }

    @Override
    public User findById(String id) {
        return (User)abstr.findById(id);
    }

    public SimpleArray<User> getArray() {
        return abstr.getArray();
    }
}
