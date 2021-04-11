package maze;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Base class for all maze types
 *
 * @param <CoordinateType> the type of coordinates
 */
public abstract class MazeBase<CoordinateType extends Coordinate> implements Maze {

    public abstract MazeCellType getCellType(@NotNull CoordinateType cell);

    public abstract void setCellType(@NotNull CoordinateType cell, MazeCellType cellType);

    public abstract boolean isValidCoordinate(@Nullable CoordinateType coordinate);

    /**
     * Get all neighbors of a cell
     */
    public abstract @NotNull List<CoordinateType> getNeighbors(@NotNull CoordinateType cell);

    /**
     * Get all neighbors of a cell that are of a specific type
     */
    public abstract @NotNull List<CoordinateType> getNeighborsOfType(@NotNull CoordinateType cell, MazeCellType cellType);
}
