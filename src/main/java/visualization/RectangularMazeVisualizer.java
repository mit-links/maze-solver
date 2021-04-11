package visualization;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import maze.Coordinate2D;
import maze.Maze;
import maze.RectangularMaze;
import org.jetbrains.annotations.NotNull;

/**
 * Visualizes rectangular mazes
 */
public class RectangularMazeVisualizer extends VisualizerBase<RectangularMaze> {

    public RectangularMazeVisualizer(@NotNull Stage stage) {
        super(stage);
    }

    @Override
    public void visualizeMaze(@NotNull RectangularMaze maze) {
        var canvas = new ResizableCanvas(maze);
        canvas.draw();

        var root = new Pane(canvas);
        var scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Maze");
        stage.show();

        //redraw the canvas every time the stage size changes
        stage.widthProperty().addListener(c -> {
            canvas.setWidth(stage.getWidth());
            canvas.setHeight(stage.getHeight());
        });
        stage.heightProperty().addListener(c -> {
            canvas.setWidth(stage.getWidth());
            canvas.setHeight(stage.getHeight());
        });
    }

    private static class ResizableCanvas extends Canvas {
        private static final double initialWidth = 1500;
        private final @NotNull Maze maze;

        public ResizableCanvas(@NotNull Maze maze) {
            super(initialWidth, initialWidth * maze.getHeight() / maze.getWidth());
            this.maze = maze;

            // Redraw canvas when size changes.
            widthProperty().addListener(c -> draw());
            heightProperty().addListener(c -> draw());
        }

        private void draw() {
            var blockWidth = getWidth() / maze.getWidth();
            var blockHeight = getHeight() / maze.getHeight();
            var blockSize = Math.floor(Math.min(blockWidth, blockHeight));

            if (blockSize == 0) {
                System.out.println("Maze is too large to draw");
                setWidth(0);
                setHeight(0);
                return;
            }

            var context = getGraphicsContext2D();

            context.setFill(backgroundColor);
            context.fillRect(0, 0, getWidth(), getHeight());

            for (var y = 0; y < maze.getHeight(); y++) {
                for (var x = 0; x < maze.getWidth(); x++) {
                    var color = backgroundColor;
                    switch (maze.getCellTypeGeneric(new Coordinate2D(x, y))) {
                        case EMPTY -> color = emptyColor;
                        case WALL -> color = wallColor;
                        case SOLUTION_PATH -> color = solutionColor;
                        case ERROR_PATH -> color = errorColor;
                    }
                    context.setFill(color);
                    context.fillRect(x * blockSize, y * blockSize, blockSize, blockSize);
                }
            }
        }

        @Override
        public boolean isResizable() {
            return true;
        }

        @Override
        public double prefWidth(double height) {
            return getWidth();
        }

        @Override
        public double prefHeight(double width) {
            return getHeight();
        }
    }
}
