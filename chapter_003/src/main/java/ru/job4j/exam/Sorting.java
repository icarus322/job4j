package ru.job4j.exam;

import java.util.*;


public class Sorting {

    private List<Organization> departments = new ArrayList<>();

    public void addDepartment(Organization department) {
        departments.add(department);
    }


  
    public List<Organization> sortOrgsFromA() {
        Comparator<Organization> comparator = (o1, o2) -> {
            int result;
            if (o1 == null) {
                result = -1;
            } else if (o2 == null) {
                result = 1;
            } else if (o1.getDepartment().toString().equals(o2.getDepartment().toString())) {
                result = 0;
            } else {
                result = o1.compareTo(o2);
            }
            return result;
        };
        departments.sort(comparator);
        System.out.println(departments);
        return departments;
    }


//    public List<Organization> sortOrgsFromZ() {
//        Comparator<Organization> comparator = (o1, o2) -> {
//            int result;
//            if (o1 == null) {
//                result = -1;
//            }
//            else if (o2 == null) {
//                result = 1;
//            }
//            else if (o1.getDepartment().equals(o2.getDepartment())) {
//                result = 0;
//            }
//            else {
//                result = o1.getDepartment().substring(0, 2).compareTo(o2.getDepartment().substring(0, 2)) * -1;
//            }
//            return result;
//        };
//        departments.sort(comparator);
//        System.out.println(departments);
//        return departments;
//    }

}
