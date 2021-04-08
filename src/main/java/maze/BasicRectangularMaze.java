package maze;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Coordinate2D> getEmptyNeighbors(@NotNull Coordinate2D cell) {
        var allNeighbors = new Coordinate2D[]{getCellLeft(cell), getCellRight(cell), getCellAbove(cell), getCellBelow(cell)};

        return Arrays.stream(allNeighbors).filter(c -> c != null && getCellType(c) == MazeCellType.EMPTY).collect(Collectors.toList());
    }
}
