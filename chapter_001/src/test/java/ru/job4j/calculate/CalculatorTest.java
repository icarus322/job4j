package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Calculator.
 *
 * @author Sergey Polev (pirat18l@ya.ru)
 * @version 1.0
 * @since 16.04.2019
 */
public class CalculatorTest {
    /**
     * Test Add.
     */

    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test Subtract.
     */

    @Test
    public void whenSubtractOneMinusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.subtract(1D, 1D);
        double expected = 0D;
        assertThat(result, is(expected));
    }

    /**
     * Test Div.
     */

    @Test
    public void whenDivOneDividedByOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.div(1D, 1D);
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Test Multiple.
     */

    @Test
    public void whenMultipleOneMultipleByOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.multiple(1D, 1D);
        double expected = 1D;
        assertThat(result, is(expected));
    }
}