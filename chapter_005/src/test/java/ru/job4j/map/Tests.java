package ru.job4j.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Tests {
    public void start() {
        User userFirst = new User("Tom", 10, new GregorianCalendar(2009, 9, 21));
        User userSecond = new User("Tom", 10, new GregorianCalendar(2009, 9, 21));
        Map<User, Object> map = new HashMap<>();
        map.put(userFirst, null);
        map.put(userSecond, null);
        System.out.println(map);
    }

    public static void main(String[] args) {
        Tests test = new Tests();
        test.start();
    }

}
