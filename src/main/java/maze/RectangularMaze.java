package maze;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;

/**
 * A rectangular maze.
 * x coordinate goes from left to right, y coordinate from top to bottom.
 * origin (0/0) is at the top-left cells (this entails only positive coordinates).
 */
public abstract class RectangularMaze extends MazeBase<Coordinate2D> {
    private final int width;
    private final int height;

    public RectangularMaze(int width, int height) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be positive");
        }

        if (height <= 0) {
            throw new IllegalArgumentException("Height must be positive");
        }

        this.width = width;
        this.height = height;
    }

    @Override
    public MazeCellType getCellTypeGeneric(@NotNull Coordinate cell) {
        return getCellType((Coordinate2D) cell);
    }

    @Override
    public void setCellTypeGeneric(@NotNull Coordinate cell, MazeCellType cellType) {
        setCellType((Coordinate2D) cell, cellType);
    }

    @Override
    public void setAllToWalls() {
        var iterator = getIterator();
        while (iterator.hasNext()) {
            setCellType((Coordinate2D) iterator.next(), MazeCellType.WALL);
        }
    }

    @Override
    public Iterator<Coordinate> getIterator() {
        //traversing 2D arrays can be done in 2 ways: traversing row-by-row is more efficient due to caching
        return new Iterator<>() {
            private @Nullable Coordinate2D currentCoordinate = null;

            @Override
            public boolean hasNext() {
                return currentCoordinate == null || !currentCoordinate.equals(getBottomRight());
            }

            @Override
            public Coordinate next() {
                var nextCoordinate = getNext();
                currentCoordinate = nextCoordinate;
                return nextCoordinate;
            }

            private Coordinate2D getNext() {
                if (currentCoordinate == null) {
                    //iteration not started yet
                    return getTopLeft();
                }

                if (currentCoordinate.equals(getBottomRight())) {
                    //iteration completed, can't go further
                    throw new IndexOutOfBoundsException();
                }

                if (currentCoordinate.getX() == width - 1) {
                    //end of row reached
                    return new Coordinate2D(0, currentCoordinate.getY() + 1);
                }

                //regular case (neither end of row, nor end of columns reached)
                return new Coordinate2D(currentCoordinate.getX() + 1, currentCoordinate.getY());
            }
        };
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public @NotNull String getStringRepresentation() {
        var stringBuilder = new StringBuilder();

        for (var y = 0; y < height; y++) {
            for (var x = 0; x < width; x++) {
                var isWall = getCellType(new Coordinate2D(x, y)).equals(MazeCellType.WALL);
                stringBuilder.append(isWall ? "X" : "O");
            }
            stringBuilder.append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }

    public @Nullable Coordinate2D getCellLeft(@NotNull Coordinate2D cell) {
        if (cell.getX() == 0) {
            //cell is in left-most column
            return null;
        }
        return new Coordinate2D(cell.getX() - 1, cell.getY());
    }

    public @Nullable Coordinate2D getCellRight(@NotNull Coordinate2D cell) {
        if (cell.getX() == width - 1) {
            //cell is in right-most column
            return null;
        }
        return new Coordinate2D(cell.getX() + 1, cell.getY());
    }

    public @Nullable Coordinate2D getCellAbove(@NotNull Coordinate2D cell) {
        if (cell.getY() == 0) {
            //cell is in top row
            return null;
        }
        return new Coordinate2D(cell.getX(), cell.getY() - 1);
    }

    public @Nullable Coordinate2D getCellBelow(@NotNull Coordinate2D cell) {
        if (cell.getY() == height - 1) {
            //cell is in bottom row
            return null;
        }
        return new Coordinate2D(cell.getX(), cell.getY() + 1);
    }

    public Coordinate2D getTopLeft() {
        return new Coordinate2D(0, 0);
    }

    public Coordinate2D getBottomRight() {
        return new Coordinate2D(width - 1, height - 1);
    }

    protected void ValidateCell(@Nullable Coordinate2D cell) {
        if (cell == null) {
            throw new IllegalArgumentException("Cell can't be null");
        }

        if (cell.getX() < 0 || cell.getX() >= width) {
            throw new IndexOutOfBoundsException("x coordinate of cell is out of bounds: %d. Must be in [0, %d)".formatted(cell.getX(), width));
        }
        if (cell.getY() < 0 || cell.getY() >= height) {
            throw new IndexOutOfBoundsException("y coordinate of cell is out of bounds: %d. Must be in [0, %d)".formatted(cell.getY(), height));
        }
    }
}