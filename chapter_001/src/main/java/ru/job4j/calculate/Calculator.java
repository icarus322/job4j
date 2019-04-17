package ru.job4j.calculate;

/**
 * Calculate.
 *
 * @author Sergey Polev (pirat18l@ya.ru)
 * @version 1.0
 * @since 16.04.2019
 */
public class Calculator {

	/**
	 * Add.
	 * @param first - args
	 * @param second - args
	 * @return first plus second.
	 */
	public double add(double first, double second) {
		return first + second;
	}

	/**
	 * Add.
	 * @param first - args
	 * @param second - args
	 * @return first minus second.
	 */
	public double subtract(double first, double second) {
		return first - second;
	}
	/**
	 * Add.
	 * @param first - args
	 * @param second - args
	 * @return first divided by second.
	 */
	public double div(double first, double second) {
		return first % second;
	}

	/**
	 * Add.
	 * @param first - args
	 * @param second - args
	 * @return first multiple by second.
	 */
	public double multiple(double first, double second) {
		return first * second;
	}

}