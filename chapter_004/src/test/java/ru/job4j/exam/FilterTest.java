package ru.job4j.exam;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class FilterTest {

    @Test
    public void thenResultIs226() {
        Filter filter = new Filter();
        var result = filter.examFilter(new Integer[]{0, 1, 2, 15, 34});
        assertThat(result, is(226));
    }
}
