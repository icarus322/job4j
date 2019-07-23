package ru.job4j.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserConvert {

    User user = new User();
    private List<User> users = new ArrayList<>();

    public void add(User user) {
        this.users.add(user);
    }

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        for (User convert: this.users) {
            result.putIfAbsent(Integer.valueOf(convert.getId()), convert);
        }

        return result;
    }

}
