package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (Math.abs(source.y - dest.y) == Math.abs(source.x - dest.x)) {
            steps = new Cell[Math.abs(source.y - dest.y)];
            if(source.y > dest.y && source.x > dest.x) {
                String tmp = null;
                int temp = source.y;
                for (int i = 0; i < Math.abs(source.y - dest.y); i++) {
                    switch (temp){
                        case 1 : tmp = "A";
                        break;
                        case 2 : tmp = "B";
                            break;
                        case 3 : tmp = "C";
                            break;
                        case 4 : tmp = "D";
                            break;
                        case 5 : tmp = "E";
                            break;
                        case 6 : tmp = "F";
                            break;
                        case 7 : tmp = "G";
                            break;
                    }
                    temp++;
                    steps[i] = Cell.valueOf(tmp + (source.x - 1 - i));
                    System.out.println(steps[i]);

                }
            }
       //     steps = new Cell[] { dest };
            }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
