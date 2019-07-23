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
            int quantityX = Math.abs(source.x - dest.x);
            int deltaX = 0;
            int deltaY = 0;

            if (source.x > dest.x) {
                deltaX = -1;
            } else if (source.x < dest.x){
                deltaX = 1;
            }
            if (source.y > dest.y) {
                deltaY = -1;
            } else if (source.y < dest.y){
                deltaY = 1;
            }

            Cell[] tmp = new Cell[quantityX + 1];
            for (int i = 1; i <= quantityX; i++) {
                tmp[i] = Cell.findByXY(source.x + deltaX, source.y + deltaY);
                deltaX = deltaX + deltaX;
                deltaY = deltaY + deltaY;
            }
            steps = tmp;
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
