package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;
import java.util.Optional;


public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (steps.length > 0 && moveTest(source,dest)) {
                for (int i = 0; i < 32; i++) {
                    if (dest.equals(figures[i].position())) {
                        rst = false;
                        break;
                    } else if (i == 31){
                        rst = true;
                        this.figures[index] = this.figures[index].copy(dest);
                    }
                }
            }
        }
        return rst;
    }
    public boolean moveTest(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] tmp = path(source, dest);
            for (int i = 1; i < tmp.length; i++) {
                System.out.println(tmp[i] + " move test");
                for (int j = 0; j < 32; j++) {
                    if (tmp[i].equals(figures[j].position())) {
                        rst = false;
                        i = tmp.length;
                        break;
                    } else if (j == 31) {
                        rst = true;
                    }
                }
            }
        }
        System.out.println(rst + " moveTest");
        return rst;
    }

    public Cell[] path(Cell source, Cell dest) {
        Cell[] result = new Cell[0];
        int deltaX = Math.abs(source.x - dest.x);
        int deltaY = Math.abs(source.y - dest.y);
        if(source.x < dest.x && source.y < dest.y) {
            Cell[] tmp = new Cell[deltaX + 1];
            for (int i = 0; i <= deltaX; i++) {
                tmp[i] = Cell.findByXY(source.x + i, source.y + i);
            }
            result = tmp;
        }
        if(source.x > dest.x && source.y < dest.y) {
            Cell[] tmp = new Cell[deltaX + 1];
            for (int i = 0; i <= deltaX; i++) {
                tmp[i] = Cell.findByXY(source.x - i, source.y + i);
            }
            result = tmp;
        }
        if(source.x < dest.x && source.y > dest.y) {
            Cell[] tmp = new Cell[deltaX + 1];
            for (int i = 0; i <= deltaX; i++) {
                tmp[i] = Cell.findByXY(source.x + i, source.y - i);
            }
            result = tmp;
        }
        if(source.x > dest.x && source.y > dest.y) {
            Cell[] tmp = new Cell[deltaX + 1];
            for (int i = 0; i <= deltaX; i++) {
                tmp[i] = Cell.findByXY(source.x - i, source.y - i);
                System.out.println(tmp[i] + " path");
            }
            result = tmp;
        }
        if(source.x > dest.x && source.y == dest.y) {
            Cell[] tmp = new Cell[deltaX + 1];
            for (int i = 0; i <= deltaX; i++) {
                tmp[i] = Cell.findByXY(source.x - i, source.y);
                System.out.println(tmp[i] + " path x--");
            }
            result = tmp;
        }
        if(source.x < dest.x && source.y == dest.y) {
            Cell[] tmp = new Cell[deltaX + 1];
            for (int i = 0; i <= deltaX; i++) {
                tmp[i] = Cell.findByXY(source.x + i, source.y);
                System.out.println(tmp[i] + " path x++" + " deltaX=" + deltaX + " i=" + i);
            }
            result = tmp;
        }
        if(source.x == dest.x && source.y > dest.y) {
            Cell[] tmp = new Cell[deltaY + 1];
            for (int i = 0; i <= deltaY; i++) {
                tmp[i] = Cell.findByXY(source.x, source.y - i);
                System.out.println(tmp[i] + " path y-- " + " deltaY=" + deltaY + " i=" + i);
            }
            result = tmp;
        }
        if(source.x == dest.x && source.y < dest.y) {
            Cell[] tmp = new Cell[deltaY + 1];
            for (int i = 0; i <= deltaY; i++) {
                tmp[i] = Cell.findByXY(source.x, source.y + i);
                System.out.println(tmp[i] + " path y++");
            }
            result = tmp;
        }


        return result;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
