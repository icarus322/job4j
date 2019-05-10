package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
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
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserTryToShowAllItemsThenTrackerHasShowAllItems() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
                is(SB
                        +
                        new StringBuilder()
                                .append("------------ Список заявок --------------")
                                .append(System.lineSeparator())
                                .append("Номер")
                                .append(System.lineSeparator())
                                .append("------------ Конец списка заявок --------------")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    @Test
    public void whenUserTryToFindItemByIdThenTrackerHasShowAllItemsWithThisId() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"4", "test", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
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
        Input input = new StubInput(new String[]{"5", "test", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(out.toByteArray()),
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