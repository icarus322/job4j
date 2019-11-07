package ru.job4j.generic;


public class RoleStore extends AbstractStore<Role>{


    public RoleStore(Role[] roles) {
        super(roles);
    }


    public void add(Role model) {
        super.add(model);
    }


    public boolean replace(String id, Role model) {
        return super.replace(id, model);
    }


    public boolean delete(String id) {
        return super.delete(id);
    }


    public Role findById(String id) {
        return super.findById(id);
    }

    public SimpleArray<Role> getArray() {
        return super.getArray();
    }
}
