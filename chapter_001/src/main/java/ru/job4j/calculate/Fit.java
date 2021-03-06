package ru.job4j.calculate;

/**
 * Программа расчета идеального веса.
 *
 * @author Sergey Polev (pirat18l@ya.ru)
 * @version 1.0
 * @since 18.04.2019
 */

public class Fit {

    /**
     * Идеальный вес для мужщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * Идеальный вес для женщины.
     * @param height Рост.
     * @return идеальный вес.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }

}
