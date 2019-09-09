package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream out = System.out;
    private ByteArrayOutputStream bas = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(bas);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        @Override
        public String toString() {
            return bas.toString();
        }
    };

    private static final String SB = new StringBuilder()
            .append("0. Add new Item.")
            .append(System.lineSeparator())
            .append("1. Show Items.")
            .append(System.lineSeparator())
            .append("2. Update Item.")
            .append(System.lineSeparator())
            .append("3. Delete Item.")
            .append(System.lineSeparator())
            .append("4. Find Item by ID.")
            .append(System.lineSeparator())
            .append("5. Find Item by name.")
            .append(System.lineSeparator())
            .toString();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.out);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserTryToShowAllItemsThenTrackerHasShowAllItems() {
        Tracker tracker = new Tracker();
        new StartUI(new StubInput(new String[]{"1", "6"}), tracker, output).init();
        String expect = (SB
                +
                new StringBuilder()
                        .append("------------ Список заявок --------------")
                        .append(System.lineSeparator())
                        .append("Номер")
                        .append(System.lineSeparator())
                        .append("------------ Конец списка заявок --------------")
                        .append(System.lineSeparator())
                        .toString()
        );
        assertThat(this.output.toString(), is(expect));
    }

    @Test
    public void whenUserTryToFindItemByIdThenTrackerHasShowAllItemsWithThisId() {
        Tracker tracker = new Tracker();
        new StartUI(new StubInput(new String[]{"4", "test", "6"}), tracker, output).init();
        assertThat(this.output.toString(),
                is(SB
                        +
                        new StringBuilder()
                                .append("Такой заявки не существует")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenUserTryToFindItemByNameThenTrackerHasShowAllItemsWithThisName() {
        Tracker tracker = new Tracker();
        new StartUI(new StubInput(new String[]{"5", "test", "6"}), tracker, output).init();
        assertThat(this.output.toString(),
                is(SB
                        +
                        new StringBuilder()
                                .append("------------ Список заявок c именем: test --------------")
                                .append(System.lineSeparator())
                                .append("------------ Конец списка заявок --------------")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

}