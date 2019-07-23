package ru.job4j.list;

import org.junit.Test;

public class UserConvertTest {
    @Test
    public void whenFindById() {
        UserConvert convert = new UserConvert();
        convert.add(
                new User("544", "Tom", "Omsk")
        );
        convert.add(
                new User("18", "Ivan", "Minsk")
        );
        convert.add(
                new User("5", "Bran", "Kiev")
        );

    }
}
