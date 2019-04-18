package ru.job4j.calculate;

/**
 * Converter.
 *
 * @author Sergey Polev (pirat18l@ya.ru)
 * @version 1.0
 * @since 18.04.2019
 */
public class Converter {

	/**
	 * Convert ruble to euro.
	 * @param value - ruble.
	 * @return Euro.
	 */
	public int rubleToEuro(int value) {
		return value / 70;
	}

	/**
	 * Convert ruble to dollar.
	 * @param value - ruble.
	 * @return Dollar.
	 */
	public int rubleToDollar(int value) {
		return value / 60;
	}

	/**
	 * Convert euro to ruble.
	 * @param value - euro.
	 * @return Ruble.
	 */
	public int euroToRuble(int value) {
		return value * 70;
	}

	/**
	 * Convert dollar to ruble.
	 * @param value - dollar.
	 * @return Ruble.
	 */
	public int dollarToRuble(int value) {
		return value * 60;
	}

}