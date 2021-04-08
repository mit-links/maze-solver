package maze;

import org.jetbrains.annotations.NotNull;

/**
 * A Maze
 */
public interface Maze {

    MazeCellType getCellTypeGeneric(@NotNull Coordinate cell);

    int getWidth();

    int getHeight();

    /**
     * Get an ASCII art-style string representation of this maze
     */
    @NotNull String getStringRepresentation();
}
