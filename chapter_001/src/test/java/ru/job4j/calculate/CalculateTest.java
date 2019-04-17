package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Sergey Polev (pirat18l@ya.ru)
 * @version 1.0
 * @since 16.04.2019
 */
public class CalculateTest {
    /**
     * Test echo.
     */

    @Test
    public void whenTakeNameThenThreeEchoPlusName() {
        String input = "Sergey Polev";
        String expect = "Echo, echo, echo : Sergey Polev";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
    }
}