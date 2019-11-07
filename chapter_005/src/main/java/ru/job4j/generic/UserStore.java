package ru.job4j.generic;



public class UserStore extends AbstractStore<User> {

    public UserStore(User[] users) {
        super(users);
    }

    public void add(User model) {
        super.add(model);
    }

    public boolean replace(String id, User model) {
        return super.replace(id, model);
    }

    public boolean delete(String id) {
        return super.delete(id);
    }

    public User findById(String id) {
        return super.findById(id);
    }

    public SimpleArray<User> getArray() {
        return super.getArray();
    }
}
