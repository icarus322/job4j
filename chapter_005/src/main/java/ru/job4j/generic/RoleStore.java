package ru.job4j.generic;


public class RoleStore implements Store<Role>{

    AbstractStore abstr;

    public RoleStore(Role[] Roles) {
        abstr = new AbstractStore(Roles);
    }

    @Override
    public void add(Role model) {
        abstr.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return abstr.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return abstr.delete(id);
    }

    @Override
    public Role findById(String id) {
        return (Role)abstr.findById(id);
    }

    public SimpleArray<Role> getArray() {
        return abstr.getArray();
    }
}
