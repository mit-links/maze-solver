package visualize;

import javafx.scene.paint.Color;
import maze.Maze;
import org.jetbrains.annotations.NotNull;

/**
 * Visualizes mazes and solutions
 */
public interface Visualizer {

    Color backgroundColor = Color.rgb(255, 255, 255);
    Color wallColor = Color.rgb(0, 0, 0);
    Color emptyColor = Color.rgb(200, 200, 200);
    Color solutionColor = Color.rgb(0, 255, 0);
    Color errorColor = Color.rgb(255, 0, 0);

    /**
     * Visualize a maze by using {@link Maze:getStringRepresentation}
     */
    void visualizeGeneric(@NotNull Maze maze);
}
