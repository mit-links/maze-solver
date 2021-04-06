package visualize;

import core.mazes.Maze;
import org.jetbrains.annotations.NotNull;

/**
 * Visualizes mazes and solutions
 */
public interface Visualizer {
    /**
     * Visualize a maze by using {@link Maze:getStringRepresentation}
     */
    void visualizeGeneric(@NotNull Maze maze);
}
