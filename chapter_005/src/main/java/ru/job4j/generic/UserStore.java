package ru.job4j.generic;



public class UserStore<T extends User> extends AbstractStore<T> implements Store<T>{

    public UserStore(T[] users) {
        super(users);
    }

    @Override
    public void add(T model) {
        super.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return super.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(id);
    }

    @Override
    public T findById(String id) {
        return super.findById(id);
    }

    public SimpleArray<T> getArray() {
        return super.getArray();
    }
}
