package ru.job4j.generic;


public class RoleStore extends AbstractStore implements Store<Role>{


    public RoleStore(Role[] roles) {
        super(roles);
    }

    @Override
    public void add(Role model) {
        super.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return super.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return super.delete(id);
    }

    @Override
    public Role findById(String id) {
        return (Role)super.findById(id);
    }

    public SimpleArray<Role> getArray() {
        return super.getArray();
    }
}
