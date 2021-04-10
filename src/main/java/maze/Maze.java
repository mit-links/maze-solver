package maze;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * A Maze
 */
public interface Maze {

    MazeCellType getCellTypeGeneric(@NotNull Coordinate cell);

    void setCellTypeGeneric(@NotNull Coordinate cell, MazeCellType cellType);

    /**
     * Set all cells to be a Wall
     */
    void setAllToWalls();

    Iterator<Coordinate> getIterator();

    int getWidth();

    int getHeight();

    /**
     * Get an ASCII art-style string representation of this maze
     */
    @NotNull String getStringRepresentation();
}
