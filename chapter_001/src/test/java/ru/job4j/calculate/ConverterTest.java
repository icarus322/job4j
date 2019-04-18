package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Converter.
 *
 * @author Sergey Polev (pirat18l@ya.ru)
 * @version 1.0
 * @since 18.04.2019
 */
public class ConverterTest {
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }

    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }
    @Test
    public void when5DollarToRubleThen300() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(5);
        assertThat(result, is(300));
    }

    @Test
    public void when5EuroToRubleThen350() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(5);
        assertThat(result, is(350));
    }

}