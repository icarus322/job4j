package ru.job4j.tracker;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = this.input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.printf("Error: %s Please select key from menu. %n", moe.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.printf("Error: %s Please enter validate data again. %n", nfe.getMessage());
            }
        } while (invalid);
        return  value;
    }
}
