package creator;

import maze.BasicRectangularMaze;
import maze.RectangularMaze;
import org.jetbrains.annotations.NotNull;

/**
 * Creates a {@link BasicRectangularMaze}
 */
public class BasicRectangularMazeCreator extends RectangularMazeCreator {

    @Override
    protected @NotNull RectangularMaze CreateMazeTemplate(int width, int height) {
        return new BasicRectangularMaze(width, height);
    }
}
