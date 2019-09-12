package ru.job4j.lambda;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FunctionsTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Functions functions = new Functions();
        List<Double> result = functions.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Functions functions = new Functions();
        List<Double> result = functions.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Functions functions = new Functions();
        List<Double> result = functions.diapason(10, 12, Math::log10);
        List<Double> expected = Arrays.asList(1.0D, 1.0413926851582251D);
        assertThat(result, is(expected));
    }
}
