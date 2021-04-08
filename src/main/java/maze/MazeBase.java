package maze;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Base class for all maze types
 *
 * @param <CoordinateType> the type of coordinates
 */
public abstract class MazeBase<CoordinateType extends Coordinate> implements Maze {

    public abstract MazeCellType getCellType(@NotNull CoordinateType cell);

    public abstract void setCellType(@NotNull CoordinateType cell, MazeCellType cellType);

    /**
     * Get all neighbors that are of type {@link MazeCellType:EMPTY}
     */
    public abstract List<CoordinateType> getEmptyNeighbors(@NotNull CoordinateType cell);
}
