package ru.job4j.generic;

import java.util.Objects;

public class Role extends Base {

    private final String id = super.getId();

    public Role(String id) {
        super(id);
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
