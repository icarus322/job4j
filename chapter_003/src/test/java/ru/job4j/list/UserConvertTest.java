package ru.job4j.list;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenFindById() {
        UserConvert convert = new UserConvert();
        User user1 = new User("82", "Tom", "Omsk");
        User user2 = new User("5", "Mark", "Minsk");
        User user3 = new User("512", "Ivan", "Kiev");
        List<User> users = Arrays.asList(user1, user2, user3);
        Map<Integer, User> process = convert.process(users);
        Map<Integer, User> map = new HashMap<>();
        map.put(Integer.valueOf(user1.getId()), user1);
        map.put(Integer.valueOf(user2.getId()), user2);
        map.put(Integer.valueOf(user3.getId()), user3);
        assertThat(process, is(map));
    }
}
