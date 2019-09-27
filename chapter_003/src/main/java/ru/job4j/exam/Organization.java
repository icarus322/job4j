package ru.job4j.exam;


import java.util.List;
import java.util.Objects;

public class Organization implements Comparable<Organization> {

    private List<String> department;

    public List<String> getDepartment() {
        return department;
    }

    public Organization(List<String> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.join("/", department);
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

    @Override
    public int compareTo(Organization o) {
        return this.department.get(0).length() - o.getDepartment().get(0).length();
    }
}
