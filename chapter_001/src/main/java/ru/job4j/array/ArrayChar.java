package ru.job4j.array;

/**
 * Обертка над строкой.
 */
public class ArrayChar {
    private char[] data;

    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет, что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = false;
//        char[] value = prefix.toCharArray();
        String text = String.valueOf(data);
        if (text.startsWith(prefix)) {
            result = true;
        }
        return result;
    }
}