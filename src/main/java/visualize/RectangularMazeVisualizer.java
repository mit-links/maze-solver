package visualize;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import maze.Coordinate2D;
import maze.RectangularMaze;
import org.jetbrains.annotations.NotNull;

/**
 * Visualizes rectangular mazes
 */
public class RectangularMazeVisualizer extends VisualizerBase<RectangularMaze> {

    private static final int blockSize = 12;

    public RectangularMazeVisualizer(@NotNull Stage stage) {
        super(stage);
    }

    @Override
    public void visualizeMaze(@NotNull RectangularMaze maze) {
        var canvas = new Canvas(blockSize * maze.getWidth(), blockSize * maze.getHeight());
        var context = canvas.getGraphicsContext2D();

        context.setFill(backgroundColor);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (var y = 0; y < maze.getHeight(); y++) {
            for (var x = 0; x < maze.getWidth(); x++) {
                var color = backgroundColor;
                switch (maze.getCellType(new Coordinate2D(x, y))) {
                    case EMPTY -> color = emptyColor;
                    case WALL -> color = wallColor;
                    case SOLUTION_PATH -> color = solutionColor;
                    case ERROR_PATH -> color = errorColor;
                }
                context.setFill(color);
                context.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
            }
        }

        var root = new Pane(canvas);
        var scene = new Scene(root);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("Maze");
        stage.show();
    }
}
