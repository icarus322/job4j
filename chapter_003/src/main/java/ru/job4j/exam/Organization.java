package ru.job4j.exam;


import java.util.Objects;

public class Organization {

    private String department;

    public String getDepartment() {
        return department;
    }

    public Organization(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department);
    }
}
