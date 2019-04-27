package ru.job4j.condition;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Categories;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;


public class TriangleTest {
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        // Создаем объект треугольник.
        Point point1 = new Point(0, 0);
        Point point2 = new Point(0, 2);
        Point point3 = new Point(2, 0);
        Triangle triangle = new Triangle(point1, point2, point3);
        // Вычисляем площадь. 0, 0, 0, 2, 2, 0
        double result = triangle.area();
        // Задаем ожидаемый результат.
        double expected = 2D;
        //Проверяем результат и ожидаемое значение.
        assertThat(result, closeTo(expected, 0.1));
    }
}
