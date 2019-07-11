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
            int deltaX = Math.abs(source.x - dest.x);
            if(source.x < dest.x && source.y < dest.y) {
                Cell[] tmp = new Cell[deltaX + 1];
                for (int i = 0; i <= deltaX; i++) {
                    tmp[i] = Cell.findByXY(source.x + i, source.y + i);
                }
                steps = tmp;
            }
            if(source.x > dest.x && source.y < dest.y) {
                Cell[] tmp = new Cell[deltaX + 1];
                for (int i = 0; i <= deltaX; i++) {
                    tmp[i] = Cell.findByXY(source.x - i, source.y + i);
                }
                steps = tmp;
            }
            if(source.x < dest.x && source.y > dest.y) {
                Cell[] tmp = new Cell[deltaX + 1];
                for (int i = 0; i <= deltaX; i++) {
                    tmp[i] = Cell.findByXY(source.x + i, source.y - i);
                }
                steps = tmp;
            }
            if(source.x > dest.x && source.y > dest.y) {
                Cell[] tmp = new Cell[deltaX + 1];
                for (int i = 0; i <= deltaX; i++) {
                    tmp[i] = Cell.findByXY(source.x - i, source.y - i);
                }
                steps = tmp;
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
