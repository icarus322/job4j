package ru.job4j.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class MatrixTest {

    @Test
    public void thenIntegerMatrixConvertToList() {
        Matrix matrix = new Matrix();
        Integer[][] temp = {{1, 2}, {3, 4}};
        List<Integer> result = matrix.convert(temp);
        List<Integer> expect = new ArrayList<>();
        expect.add(1);
        expect.add(2);
        expect.add(3);
        expect.add(4);
        assertThat(result, is(expect));
    }

}
