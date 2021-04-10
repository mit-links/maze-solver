package maze;

import org.jetbrains.annotations.NotNull;

public class BasicRectangularMaze extends RectangularMaze {

    private final @NotNull MazeCellType[][] cells;

    public BasicRectangularMaze(int width, int height) {
        super(width, height);
        cells = new MazeCellType[width][height];
    }

    @Override
    public MazeCellType getCellType(@NotNull Coordinate2D cell) {
        ValidateCell(cell);
        return cells[cell.getX()][cell.getY()];
    }

    @Override
    public void setCellType(@NotNull Coordinate2D cell, MazeCellType cellType) {
        ValidateCell(cell);
        cells[cell.getX()][cell.getY()] = cellType;
    }
}
