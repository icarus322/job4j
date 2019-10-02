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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Organization that = (Organization) o;
        return Objects.equals(department, that.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(department);
    }

    @Override
    public int compareTo(Organization o) {
        int result = 0;
        if (this.department.size() == 3 || o.getDepartment().size() == 3) {
            if (this.department.size() > o.getDepartment().size()) {
                result = 4;
            }
            if (this.department.size() < o.getDepartment().size()) {
                result = -4;
            }
            if (this.department.size() == o.getDepartment().size()) {
                result = this.department.get(1).compareTo(o.getDepartment().get(1)) * 2;
            }
        }

        if (this.department.size() == 2 || o.getDepartment().size() == 2) {
            if (this.department.size() > o.getDepartment().size()) {
                result = 10;
            }
            if (this.department.size() < o.getDepartment().size()) {
                result = -10;
            }
            if (this.department.size() == o.getDepartment().size()) {
                result = this.department.get(0).compareTo(o.getDepartment().get(0)) * 5;
            }
        }

        if (this.department.size() == 1 || o.getDepartment().size() == 1) {
            if (this.department.size() > o.getDepartment().size()) {
                result = 20;
            }
            if (this.department.size() < o.getDepartment().size()) {
                result = -20;
            }
            if (this.department.size() == o.getDepartment().size()) {
                result = this.department.get(0).compareTo(o.getDepartment().get(0)) * 40;
            }
        }

        System.out.println(this.department + " " + o.getDepartment() + " " + result);
        return result;
    }
}
