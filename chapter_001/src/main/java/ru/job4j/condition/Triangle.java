package ru.job4j.condition;

public class Triangle {

    /**
     * Метод вычисления периметра по длинам сторон.
     *
     * @param a расстояние между точками a b
     * @param b расстояние между точками a c
     * @param c расстояние между точками b c
     * @return Перимент.
     */
    public double period(double a, double b, double c) {
        double result = (a + b +c) / 2;
        return result;
    }

    /**
     * Метод должен вычислить прощадь треугольканива.
     *
     * @return Вернуть прощадь, если треугольник существует или -1.
     */
    public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        double rsl = -1;
        double a = new Point().distance(x1, y1, x2, y2);
        double b = new Point().distance(x2, y2, x3, y3);
        double c = new Point().distance(x1, y1, x3, y3);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            rsl = Math.sqrt(p *(p - a) * (p - b) * (p - c));
        }
        return rsl;
    }

    /**
     * @param a Длина от точки a b.
     * @param c Длина от точки a c.
     * @param b Длина от точки b c.
     */
    private boolean exist(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
