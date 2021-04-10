package visualization;

import javafx.stage.Stage;
import maze.Maze;
import org.jetbrains.annotations.NotNull;

/**
 * Visualizes mazes
 *
 * @param <MazeType> the maze type that this class visualizes
 */
public abstract class VisualizerBase<MazeType extends Maze> implements Visualizer {

    @NotNull
    protected final Stage stage;

    public VisualizerBase(@NotNull Stage stage) {
        this.stage = stage;
    }

    /**
     * Visualize a maze graphically
     */
    public abstract void visualizeMaze(@NotNull MazeType maze);

    @Override
    public void visualizeGeneric(@NotNull Maze maze) {
        System.out.println(maze.getStringRepresentation());
    }
}
