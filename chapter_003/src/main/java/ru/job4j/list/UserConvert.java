package ru.job4j.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvert {

    User user = new User();
    private List<User> users = new ArrayList<>();

    public void add(User user) {
        this.users.add(user);
    }

    public Map<Integer, User> process(List<User> list) {
        Map<Integer, User> result = new HashMap<>();
        for (User convert: list) {
            result.putIfAbsent(Integer.valueOf(convert.getId()), convert);
        }
        return result;
    }

}
