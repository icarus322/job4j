package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MultiMaxTest {
    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }

    @Test
    public void whenFirstMax() {
        MultiMax check = new MultiMax();
        int result = check.max(15, 4, 2);
        assertThat(result, is(15));
    }

    @Test
    public void whenThirdMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 24);
        assertThat(result, is(24));
    }

    @Test
    public void whenAllEquals() {
        MultiMax check = new MultiMax();
        int result = check.max(8, 8, 8);
        assertThat(result, is(8));
    }
}