package visualize;

import core.mazes.Maze;
import org.jetbrains.annotations.NotNull;

/**
 * Visualizes mazes
 *
 * @param <MazeType> the maze type that this class visualizes
 */
public abstract class VisualizerBase<MazeType extends Maze> implements Visualizer {

    /**
     * Visualize a maze graphically
     */
    public abstract void visualizeMaze(@NotNull MazeType maze);

    @Override
    public void visualizeGeneric(@NotNull Maze maze) {
        System.out.println(maze.getStringRepresentation());
    }
}
